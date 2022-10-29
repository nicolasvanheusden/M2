import 'package:bike_rent/src/core/constant/colors.dart';
import 'package:bike_rent/src/core/constant/text_style.dart';
import 'package:bike_rent/src/features/bike/bloc/buy_bike/buy_bike_bloc.dart';
import 'package:bike_rent/src/features/bike/bloc/rent_bike/rent_bike_bloc.dart';
import 'package:bike_rent/src/features/bike/view/widgets/bike_card.dart';
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
            create: (context) => BuyBikeBloc()..add(const BuyBikeEvent.fetchBuyBikes()),
          ) ,
          BlocProvider(
              create: (context) => RentBikeBloc()..add(const RentBikeEvent.fetchRentBikes()),
          ),
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
                        return GridView(
                          gridDelegate: const SliverGridDelegateWithMaxCrossAxisExtent(
                            maxCrossAxisExtent: 5,
                          ),
                          children: success.bikes.map((bike) => BikeCard(bike: bike, isRenting: true,)).toList(),
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
                        return GridView(
                          gridDelegate: const SliverGridDelegateWithMaxCrossAxisExtent(
                            maxCrossAxisExtent: 5,
                          ),
                          children: success.bikes.map((bike) => BikeCard(bike: bike, isRenting: false,)).toList(),
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
          ),
        );
      }
    );
  }
}