val triples = sc.parallelize(List((1,0,5),(5,1,8),(8,2,1),(2,0,6),(3,0,6),(6,1,9),(5,1,9),(9,3,11),(9,4,12),(4,0,7),(7,1,9),(7,2,10),(14,1,15),
(15,1,16),(14,1,16),(17,0,18),(18,0,19),(19,1,20),(20,0,17)))

val soPairs = triples.map(x => (x._1, x._3))

soPairs.persist()

val subjects = soPairs.map(x => x._1 )
val objects = soPairs.map(x=> x._2)

val roots = subjects.subtract(objects).distinct
val leaves = objects.subtract(subjects).distinct

val soPairsInv = soPairs.map(x => (x._2, x._1))

soPairs.unpersist()


var soPairs = triples.map(x => (x._1, x._3))
var size = soPairs.count
var soPairsInv = soPairs.map(x => (x._2, x._1))
var newSize = 0L 

while (size != newSize) {
    size = soPairs.count
    var union = soPairs.join(soPairsInv).map({case(a, b) => b})
    soPairs = (soPairs ++ union).distinct
    soPairsInv = soPairs.map(x => (x._2, x._1))
    newSize = soPairs.count
}