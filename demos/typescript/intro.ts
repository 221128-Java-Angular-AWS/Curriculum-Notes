//Typescript is a strongly typed superset of javascript. It's basically javascript with
//types, thus the name. We assign types to variables with the following syntax. 
//[identifier] : [type]
//So for instance, to create a variable called 'num' which can have numeric values assigned to it:
//let num: number
//this should be read as "let num be of type number"

let x = 5;
let i: number = 5;
var j: string = '5';
const k: number = 5;

//assigning a value that doesn't fit would give an error:
//i = 'hello';

//anywhere variables are used we want to typeify them. This includes parameter lists and return types.
function myFunc(i: number, str: string): string | undefined {
    //do stuff...
    return str;
}

function func2(): void {
    //do somehting
    return;
}


let a: any = myFunc(1, 'hi');

let v: void = func2();//no reason to do this.



//outside any clas or object, variable using let, const, var.
let something: string = "my string here";

//this is valid JS but not really TS, however don't forget that all JS is valid TS.
//you can typify these properties, in two different ways:
let obj = {
    prop1: "value",
    prop2: "val2",
    prop3: <string> "string",
    prop4: "string" as string
}

//this is the class syntax where decvlaring variables follows yet another syntax:
class MyClass{
    a: string = 'string';
}

class Greeting {
    //fields
    name: string;
    //constructor
    constructor(name: string) {
        this.name = name;
    }
    //methods
    greet() : string {
        return "Hello, " + this.name;
    }
}
//creating an object
let greeter: Greeting = new Greeting("James");
greeter.greet(); //returns "Hello, James"