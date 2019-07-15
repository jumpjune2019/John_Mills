/*
 *	written by John Mills in collaberation with Deron Sobers
 */
window.addEventListener("load", init, false);

function init(){

	var lives = 9;
	//simple first function with no params
	var firstFunc = () => {
		console.log("Here is the first test of arrow function with a simple console log");
	}

	//simple second function showing no return statement wwhen one line of code
	//also no paranthesis needed with one parameter
	var secondFunc = double => double * 2;

	//third function showing 2 paramters that
	//raises a base to a power
	var thirdFunc = (base, exp) => {
		var count = base;
		for(var i=1; i < exp; i++){
			count *= base;
		}
		if(base == 0){
			return 1;
		}
		return count;
	}


	//testing the "this" keyword using regular function
	//versus using arrow functions
	var cat = {
  		//lives: 9,
  		jumps: () => {
    		this.lives--;
 		 }
	}

	var cat1 = {
  		//lives: 9,
  		jumps: function() {
    		this.lives--;
 		 }
	}




	//here is where I am calling each function for testing
	firstFunc();
	console.log(secondFunc(4));
	console.log(thirdFunc(2, 4));
	cat.jumps();
	cat1.jumps();
	console.log("cat lives with ()=> " + cat.lives);
	console.log("cat lives with ()=> " + cat1.lives);


}//end init