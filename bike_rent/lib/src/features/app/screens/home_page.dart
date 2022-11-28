import 'package:bike_rent/src/core/constant/colors.dart';
import 'package:bike_rent/src/core/constant/text_style.dart';
import 'package:bike_rent/src/features/bike/bloc/buy_bike/buy_bike_bloc.dart';
import 'package:bike_rent/src/features/bike/bloc/rent_bike/rent_bike_bloc.dart';
import 'package:bike_rent/src/features/bike/data/datasources/bike_remote_source.dart';
import 'package:bike_rent/src/features/bike/data/repositories/bike_localhost_repository.dart';
import 'package:bike_rent/src/features/bike/view/widgets/bike_card.dart';
import 'package:bike_rent/src/features/shop_cart/bloc/shop_cart_bloc.dart';
import 'package:bike_rent/src/features/shop_cart/data/datasources/shop_cart_remote_source.dart';
import 'package:bike_rent/src/features/shop_cart/data/repositories/shop_cart_localhost_repository.dart';
import 'package:bike_rent/src/features/shop_cart/view/widget/shop_cart_button.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';


class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
        providers: [
          BlocProvider(
            create: (context) => BuyBikeBloc(BikeLocalhostRepository(BikeRemoteSource()))
              ..add(const BuyBikeEvent.fetchBuyBikes()),
          ) ,
          BlocProvider(
              create: (context) => RentBikeBloc(BikeLocalhostRepository(BikeRemoteSource()))
              ..add(const RentBikeEvent.fetchRentBikes()),
          ),
          BlocProvider(
            create: (context) => ShopCartBloc(ShopCartLocalhostRepository(ShopCartRemoteSource()))
              ..add(const ShopCartEvent.fetchBike()),
          )
        ],
      child: const HomeView(),
    );
  }
}

class HomeView extends StatefulWidget {
  const HomeView({super.key});

  @override
  State<HomeView> createState() => _HomeViewState();
}

class _HomeViewState extends State<HomeView> {
  
  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        return DefaultTabController(
          length: 2,
          child: Scaffold(
            appBar: PreferredSize(
              preferredSize: Size(constraints.maxWidth, 100),
              child: ClipRRect(
                  borderRadius: const BorderRadius.only(
                    bottomLeft: Radius.circular(20),
                    bottomRight: Radius.circular(20),
                  ),
                  child: AppBar(
                  title: Text(
                    'BlaBlaBike',
                    style: myTextStyle(fontSize: 28, fontWeight: FontWeight.w500),
                  ),
                  backgroundColor: widgetBackgroundColor,
                  actions: const [
                    ShopCartButton()
                  ],
                  bottom: TabBar(
                    labelStyle: myTextStyle(fontSize: 20),
                    indicatorColor: widgetButtonColor,
                    indicatorWeight: 5,
                    tabs: const [
                      Tab(
                        text: 'Rent',
                      ),
                      Tab(
                        text: 'Buy',
                      )
                    ],
                    
                  ),
                ),
              ),
            ),
            body: TabBarView(
              children: [
                BlocBuilder<RentBikeBloc, RentBikeState>(
                  builder: (context, state) {
                    return state.maybeMap(
                      loading: (value) => const Center(child: CircularProgressIndicator()),
                      success: (success) {
                        return Wrap(
                          // gridDelegate: const SliverGridDelegateWithMaxCrossAxisExtent(
                          //   maxCrossAxisExtent: 5,
                          // ),
                          children: success.bikes.map((bike) => BikeCard(
                            bike: bike,
                            isRenting: true,
                            onPressed: () {
                              context.read<ShopCartBloc>().add(ShopCartEvent.addBike(bike));
                            },
                            )
                          ).toList(),
                        );
                      },
                      orElse: () => const SizedBox()
                    );
                  }
                ),
                BlocBuilder<BuyBikeBloc, BuyBikeState>(
                  builder: (context, state) {
                    return state.maybeMap(
                      loading: (value) => const Center(child: CircularProgressIndicator()),
                      success: (success) {
                        return Wrap(
                          // gridDelegate: const SliverGridDelegateWithMaxCrossAxisExtent(
                          //   maxCrossAxisExtent: 5,
                          // ),
                          children: success.bikes.map((bike) => BikeCard(
                            bike: bike,
                            isRenting: false,
                            onPressed: () {
                              context.read<ShopCartBloc>().add(ShopCartEvent.addBike(bike));
                            },
                            )
                          ).toList(),
                        );
                      },
                      orElse: () => const SizedBox()
                    );
                  }
                ),
              ]
            ),
            floatingActionButton: FloatingActionButton(
              onPressed: () {},//TODO: implement add bike here
              backgroundColor: widgetButtonColor,
              child: const Icon(
                Icons.add,
              ),
            ),
            endDrawer: Drawer(
              child: BlocBuilder<ShopCartBloc, ShopCartState>(
                builder: (context, state) {
                  return state.bikesToBuy.isEmpty 
                    ? const Center(child: Text('No bikes in cart'))
                    : ListView(
                      children: [
                        ...state.bikesToBuy.map((bike) => ListTile(
                          title: Text(bike.model),
                          trailing: IconButton(
                            onPressed: () {
                              context.read<ShopCartBloc>().add(ShopCartEvent.removeBike(bike));
                            },
                            icon: const Icon(Icons.delete),
                          ),
                        ))
                      ],
                    )
                    ;
                },
              )
            ),
          ),
        );
      }
    );
  }
}