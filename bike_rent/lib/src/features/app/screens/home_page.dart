import 'package:bike_rent/src/core/constant/colors.dart';
import 'package:bike_rent/src/core/constant/text_style.dart';
import 'package:bike_rent/src/features/bike/bloc/buy_bike/buy_bike_bloc.dart';
import 'package:bike_rent/src/features/bike/data/datasources/bike_remote_source.dart';
import 'package:bike_rent/src/features/bike/data/repositories/bike_localhost_repository.dart';
import 'package:bike_rent/src/features/bike/view/widgets/bike_card.dart';
import 'package:bike_rent/src/features/shop_cart/bloc/shop_cart_bloc.dart';
import 'package:bike_rent/src/features/shop_cart/data/datasources/shop_cart_remote_source.dart';
import 'package:bike_rent/src/features/shop_cart/data/repositories/shop_cart_localhost_repository.dart';
import 'package:bike_rent/src/features/shop_cart/view/widget/shop_cart_button.dart';
import 'package:bike_rent/src/features/user/domain/user.dart';
import 'package:bike_rent/src/features/user/domain/user_type.dart';
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

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

  final TextEditingController _modelController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();
  final TextEditingController _ownerController = TextEditingController();

  var sellABike = false;

  
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
                ),
              ),
            ),
            body: BlocConsumer<BuyBikeBloc, BuyBikeState>(
              listener: (context, state) {
                if (sellABike) {
                  state.maybeWhen(
                    success: (state) {
                      setState(() {
                        sellABike = false;  
                      });
                      ScaffoldMessenger.of(context).showSnackBar(
                        const SnackBar(
                          content: Text(
                            'Bike added',
                            style: TextStyle(color: Colors.white),
                          ),
                          backgroundColor: Colors.green,
                        ),
                      );
                    },
                    orElse: () {},
                  );
                }
              },
              builder: (context, state) {
                return state.maybeMap(
                  loading: (value) => const Center(child: CircularProgressIndicator()),
                  success: (success) {
                    return Wrap(
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
            floatingActionButton: FloatingActionButton(
              onPressed: () => _showDialog(context),
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

  Future<void> _showDialog(BuildContext aboveContext) {
    return showDialog(
      context: aboveContext,
      builder: (BuildContext context) {
        return StatefulBuilder(
          builder: (context, state) {
            return AlertDialog(
              title: const Text(
                'Sell a bike'
              ),
              content: SizedBox(
                height: 200,
                child: Form(
                  key: _formKey,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      TextFormField(
                        controller: _modelController,
                        decoration: const InputDecoration(
                          hintText: 'Model',
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.all(Radius.circular(30))
                          )
                        ),
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return 'Please enter some text';
                          }
                          return null;
                        },
                      ),
                      TextFormField(
                        controller: _priceController,
                        decoration: const InputDecoration(
                          hintText: 'Price',
                          suffix: Text('€'),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.all(Radius.circular(30))
                          )
                        ),
                        validator: (value) {
                          if (value == null || value.isEmpty || int.tryParse(value) == null) {
                            return 'Please enter an amount';
                          }
                          return null;
                        },
                      ),
                      ElevatedButton(
                        onPressed: () {
                          if (_formKey.currentState!.validate()) {
                            BlocProvider.of<BuyBikeBloc>(aboveContext).add(BuyBikeEvent.sellABike(
                              _modelController.text,
                              User(id: 0, name: _ownerController.text, type: UserType.ownerParticular),
                              int.parse(_priceController.text),
                            ));
                            Navigator.of(context).pop();
                            setState(() {
                              sellABike=true;
                            });
                          }
                        },
                        child: const Text("Sell")
                      )
                    ],
                  ),
                ),
              ),

            );
          }
        );
      }
    );
  }

}