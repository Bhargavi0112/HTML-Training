let arr= [10,20,30,40,50,60];
let str="Javascript";

//for of loop
for(  val of arr){
    console.log(val);
}

for(let ch of str){
    console.log(ch);
}


//for in loop
for(let ind in arr){
    console.log(ind);
}

for(let ind in str){
    console.log(ind);
}


//for each loop
arr.forEach((val, ind, a)=>{
    console.log(val,"-> ",ind,"-> ",a);
})

console.log("---------------MAP FUNCTION-----------------");
let prices=[500,102,456,7812,1542,4512,510,12,741,41,5678];
console.log(prices)
let discountedPrices=prices.map((x)=>{
    return x-x/10;
})
console.log(discountedPrices);

let addedExtraAmount=prices.map((z)=>{
    return z+250;
})
console.log(addedExtraAmount);


console.log("-----------FILTER FUNCTION---------------");
let filteredPrices=discountedPrices.filter((x)=>{
    return x>=500&&x<=50000
})
console.log(filteredPrices);

console.log("-----------REDUCE FUNCTION--------------");
const totalPrice=filteredPrices.reduce((acl , val)=>{
    return acl+val
},500)

console.log(totalPrice);



