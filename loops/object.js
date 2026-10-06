//literal way
let empDetails={
    name:"Nidhi",
    role:"developer",
    salary:230000,
    skills:["System design", "MicroServices", "Monolithic Architecture", "Even driven", "Database Design"],
    address:{
    city:"Guntur",
    zipCode:541245
    }

}
console.log(empDetails);

//using new keyword
let emp2=new Object({name:"ravi",role:"Test Engineer"})
console.log(emp2);


let emp2=new Object({
    name:"Nidhi",
    role:"developer",
    salary:230000,
    skills:["System design", "MicroServices", "Monolithic Architecture", "Even driven", "Database Design"],
    address:{
    city:"Guntur",
    zipCode:541245
    }
})


//crud operation
console.log("------------crud operation--------------");
console.log(empDetails.name);
console.log(empDetails.skills[1]);

empDetails.skills.map((s)=>{
    console.log(s);
})

console.log(empDetails.address);

//object inbuilt function

//console.log("----------------object inbuilt  functiopn--------------------");
console.log(Object.keys(empDetails));
console.log(Object.values(empDetails));
console.log(Object.entries(empDetails));

Object.log(empDetails.address);


//object.seal(empDetails)
Object.Freeze(empDetails)
console.log(Object.isFrozen(empDetails));
console.timelog(Object.isSealed(empDetails));
empDetails.email="ravi@tcs.com"
empDetails.phone=1235688

delete empDetails.skills
delete empDetails.name;
empDetails.salary=140000

console.log(empDetails);
console.log("************************object inbuilt  function*******************")
console.log(Object.keys(empDetails));
HTMLFormControlsCollection.