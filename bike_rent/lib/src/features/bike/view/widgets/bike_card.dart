import 'package:bike_rent/src/features/bike/domain/bike.dart';
import 'package:flutter/material.dart';

class BikeCard extends StatelessWidget {
  const BikeCard({super.key, required this.bike, required this.isRenting, required this.onPressed});

  final Bike bike;
  final bool isRenting;
  final VoidCallback onPressed;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 200,
      height: 200,
      child: Card(
        margin: const EdgeInsets.all(20),
        child: Column(
          children: [
            Text(
              bike.model,
              style: const TextStyle(
                color: Colors.black
              ),
            ),
            Text(
              bike.owner.name,
              style: const TextStyle(
                color: Colors.black
              ),
            ),
            Text('${isRenting ? bike.rentPrice.toString() : bike.sellPrice.toString()} €'),
            //Text(bike.scores.map((score) => score.score).reduce((value, element) => value + element).toString()),
            const Expanded(child: SizedBox()),
            TextButton(
              onPressed: onPressed,
              child: const Text('Add to cart')
            )
          ],
        ),
      ),
    );
  }
}