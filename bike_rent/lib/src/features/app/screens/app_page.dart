
import 'package:bike_rent/src/features/app/screens/home_page.dart';
import 'package:bike_rent/src/features/bike/bloc/buy_bike/buy_bike_bloc.dart';
import 'package:bike_rent/src/features/bike/bloc/rent_bike/rent_bike_bloc.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class AppPage extends StatelessWidget {
  const AppPage({super.key});

  // This widget is the root of your application.
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
        child: MaterialApp(
        title: 'BlaBlaBike',
        debugShowCheckedModeBanner: false,
        theme: ThemeData.light(),
        home: const HomePage()
      ),
    );
  }
}
