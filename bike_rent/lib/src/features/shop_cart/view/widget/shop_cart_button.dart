import 'package:bike_rent/src/core/constant/colors.dart';
import 'package:bike_rent/src/features/shop_cart/bloc/shop_cart_bloc.dart';
import "package:flutter/material.dart";
import 'package:flutter_bloc/flutter_bloc.dart';

class ShopCartButton extends StatelessWidget {
  const ShopCartButton({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<ShopCartBloc, ShopCartState>(
      builder: (context, state) {
        return Stack(
          children: [
            IconButton(
              onPressed: () => Scaffold.of(context).openEndDrawer(), // todo(nico): navigate to shop cart screen
              icon: Icon(
                Icons.shopping_bag_rounded,
                color: widgetButtonColor,
                size: 30,
              )
            ),
            if (state.bikesToBuy.isNotEmpty)             
            Positioned(
              right: 2,
              top: 10,
              child: Container(
                width: 15,
                height: 15,
                alignment: Alignment.center,
                decoration: BoxDecoration(
                  color: backgroundScaffoldColor,
                  shape: BoxShape.circle
                ),
                child: Text(
                  state.bikesToBuy.length.toString(),
                  textAlign: TextAlign.center,
                  style: const TextStyle(
                    fontSize: 7,
                    color: Colors.white,
                  ),
                ),
              ),
            )
          ],
        );
      },
    );
  }
}