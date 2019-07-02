$.ready(function() {
	$.get('title').innerHTML = $.string.format("Quiz Game {0}", $.getVersion());


	var undoArray = [];
	var jsonArray = [];
	var checkIfUsed = [];
	var compareArray = [];
	var dropAreas = [];
	var dragItems = [];
	var totalCorrect = 0;

	//array to check if json is already
	//loaded onto page. checkIfUsed[i] will
	//be set to true once loaded down below
	for(var i=0; i < 25; i++){
		checkIfUsed.push(false);
	}

	//these variables are used for the timer
	//could not figure out how to make the it
	var timerClass = document.getElementsByClassName("elapsedTime");
	var timerSecond = document.getElementById("seconds");
	var timerMinute = document.getElementById("minutes");
	var timerHours = document.getElementById("hours");
	var seconds = 0, minutes = 0, hours = 0;


	/***************************************
	 This object will hold the references
	 of the place that the terms were last
	 dropped.
	 ***************************************/
	function undoObject(termID, answerID){

		this.term = termID;
		this.answer = answerID;

	}//end undoObject


	/******************************
	Putting elements of Json into an
	object for easy keeping
	*******************************/
	function myJsonObject(keyID){

		this.key = keyID;

	}



	/********************************************
	Loading in the json file. I suck with scope
	and returns in javascript so everything is
	basically at the global level
	*********************************************/
	var xhr = new XMLHttpRequest();
	var myObj;

	xhr.open('GET', 'data/input.json');

	xhr.onload = function(){
		if(xhr.status == 200){
			console.log("I was opened successfully");
		}else{
			console.log("Did not connect");
		}
	}

	//pulled from w3schools.com about JSON parsing
	xhr.onreadystatechange = function(){

		if(this.readyState == 4 && this.status == 200){

			myObj = JSON.parse(this.responseText);
			//could not figure out how to push this
			//using a loop since the key names are
			//different for each object
			//objects can be accessed using
			//myObj[i].term and myObj[i].definition
			jsonArray.push(myObj.key1);
			jsonArray.push(myObj.key2);
			jsonArray.push(myObj.key3);
			jsonArray.push(myObj.key4);
			jsonArray.push(myObj.key5);
			jsonArray.push(myObj.key6);
			jsonArray.push(myObj.key7);
			jsonArray.push(myObj.key8);
			jsonArray.push(myObj.key9);
			jsonArray.push(myObj.key10);
			jsonArray.push(myObj.key11);
			jsonArray.push(myObj.key12);
			jsonArray.push(myObj.key13);
			jsonArray.push(myObj.key14);
			jsonArray.push(myObj.key15);
			jsonArray.push(myObj.key16);
			jsonArray.push(myObj.key17);
			jsonArray.push(myObj.key18);
			jsonArray.push(myObj.key19);
			jsonArray.push(myObj.key20);
			jsonArray.push(myObj.key21);
			jsonArray.push(myObj.key22);
			jsonArray.push(myObj.key23);
			jsonArray.push(myObj.key24);
			jsonArray.push(myObj.key25);

		}

	}//end xhr.onreadystatechange

	xhr.send();


	/******************************************************
	Sets interval for every second and updates the timer
	********************************************************/
	function myInterval(){

		seconds++;

		if(seconds == 60){
			minutes++;
			seconds = 0;
		}

		if(minutes == 60){
			hours++;
			minutes = 0;
		}

		if(seconds < 10){
			timerSecond.innerHTML = "0" + seconds;
		}else{
			timerSecond.innerHTML = seconds;
		}

		if(minutes < 10){
			timerMinute.innerHTML = "0" + minutes + ":";
		}else{
			timerMinute.innerHTML = minutes + ":";
		}

		if(hours < 10){
			timerHours.innerHTML = "0" + hours + ":";
		}else{
			timerHours.innerHTML = hours + ":";
		}


	}//end myInterval


	/***********************************************************
	Given to us by Claude. Slightly modified where items can no
	longer be dragged once selected. Also stores items in an
	undo array for the undo functionality.
	************************************************************/
	function dragAndDrop(){


		for(var i=1; i <= 5; i++){

			dragItems.push(document.getElementById("termWidget" + i));
			dropAreas.push(document.getElementById("termDrop" + i));

		}


		function startDragItemFunc(e) {
			e.dataTransfer.setData("text", e.target.id);
		}
		
		function dropItemFunc(e) {
			e.preventDefault();

			var data = e.dataTransfer.getData("text");
			if(e.target.innerHTML == "Empty"){

				var dragEl = document.getElementById(data);
				dragEl.setAttribute('draggable', false);
				var undoMove = new undoObject(dragEl, e.target);

				e.target.innerHTML = dragEl.innerHTML;
	
				undoArray.push(undoMove);
				dragEl.innerHTML = "Empty";
				document.getElementById("undo").style.visibility = 'visible';

			}
		}
		
		function dragOverItemFunc(e) {
			e.preventDefault();
		}
	
		for(var i=0; i < 5; i++){

			dragItems[i].addEventListener("dragstart", startDragItemFunc, false);
			dropAreas[i].addEventListener("drop", dropItemFunc, false);
			dropAreas[i].addEventListener("dragover", dragOverItemFunc, false);

		}//end for loop

	}//end dragAndDrop


	//function pulled from
	//developer.mozilla.org about random numbers
	function getRandomInt(number){
		return Math.floor(Math.random() * Math.floor(number));
	}

	//checks if the correct term matches with the correct definition
	function checkIfRight(termArray, definitionArray){

		var count = 0;
		var changeColor = document.getElementsByClassName("droppedTerm");

		for(var i=0; i < 5; i++){

			//arrays are being passed from abother function
			//compareArray logs what position each item is in the definition
			//and uses that index to check it with the jsonArray which
			//holds all of the term/definition pairs
			if((termArray[i].innerHTML == jsonArray[compareArray[i]].term) && definitionArray[i].innerHTML == jsonArray[compareArray[i]].definition){
				totalCorrect++;
				count++;
				changeColor[i].style.backgroundColor = "green";
			}else{
				changeColor[i].style.backgroundColor = "red";
			}

		}//end for loop

		return count;

	}//end checkIfRight


	function play(){

		var myBtn = document.getElementById("controlButton");
		var undoBtn = document.getElementById("undo");

		var countRounds = 0;

		//changes button to "end"
		//also names because it calls itself
		//to restart the game is one chooses
		myBtn.onclick = function startRestart(){

			//var myBtn = document.getElementById("controlButton");
			var loadTerms = document.getElementsByClassName("termWidget");
			var loadDefinitions = document.getElementsByClassName("definitionText");
			var randDef = [false, false, false, false, false];
			var interval;

			document.getElementById("gameArea").style.visibility = 'visible';
			dragAndDrop();
			myBtn.innerHTML = "End";

			interval = setInterval(myInterval, 1000);

			for(var i=0; i < 5; i++){

				var randForJson = getRandomInt(25);
				var randForDef = getRandomInt(5);

				if(checkIfUsed[randForJson] == true){

					//theoretically this could run forever
					//practically it will never run forever
					//checks if same json was loaded twice
					//and forces a new check so it will never happen
					do{
						randForJson = getRandomInt(25);
					} while (checkIfUsed[randForJson] == true);

				}//end check if json has been loaded in boxes more than once
				checkIfUsed[randForJson] = true;
				
				loadTerms[i].innerHTML = jsonArray[randForJson].term;

				// *************************************************
				// Instead of keep searching for a random number that
				// has not been used, it puts it in the next available
				// slot starting from 0. Since the terms are random as
				// well, this does not affect the randomness
				// **************************************************
				if(randDef[randForDef] == true){

					randForDef = -1;
					do{
						randForDef++;
					} while(randDef[randForDef] == true);

				}
				randDef[randForDef] = true;
				loadDefinitions[randForDef].innerHTML = jsonArray[randForJson].definition;
				compareArray[randForDef] = randForJson;

			}//ends the for loop populating the boxes


			//changes button to "Show score"
			myBtn.onclick = function(){

				myBtn.innerHTML = "Show Score";
				document.getElementById("undo").style.visibility = "hidden";

				var makeUndraggable = document.getElementsByClassName("termWidget");
				for(var i=0; i < 5; i++){
					makeUndraggable[i].setAttribute('draggable', false);
				}

				clearInterval(interval);

				//changes button to "Play Again"
				myBtn.onclick = function(){

					myBtn.innerHTML = "Next Round";
					var correctAnswers = checkIfRight(dropAreas, loadDefinitions);
					var showScore = document.getElementById("score");

					if(correctAnswers == 0){
						showScore.innerHTML = "You got no correct answers in round " + (countRounds+1) + ".";
					}else if(correctAnswers == 5){
						showScore.innerHTML = "Perfect score in round " + (countRounds+1) + "!";
					}else{
						showScore.innerHTML = "You got " + correctAnswers + " correct answers in round " + (countRounds+1) + ".";
					}

					countRounds++;
					console.log("countRounds: " + countRounds);

					if(countRounds == 5){
						alert("You have run out of terms! Your got " + totalCorrect + " total over 5 rounds!");
						myBtn.innerHTML = "Play Again";
						myBtn.onclick = function(){

							undoArray = [];
							checkIfUsed = [];
							for(var i = 0; i < 25; i++){
								checkIfUsed.push(false);
							}
							compareArray = [];
							dropAreas = [];
							dragItems = [];
							seconds = 0, minutes = 0, hours = 0;
							totalCorrect = 0;
							countRounds = 0;

							var getWidgets = document.getElementsByClassName("termWidget");
							var droppedTerm = document.getElementsByClassName("droppedTerm");

							for(var i=0; i < 5; i++){
								getWidgets[i].setAttribute("draggable", true);
								droppedTerm[i].innerHTML = "Empty";
								droppedTerm[i].style.backgroundColor = "cyan";
							}
							startRestart();

						}
					}else{

						//starts the page back over again without
						//calling the ajax http request again
						myBtn.onclick = function(){

							undoArray = [];
							//checkIfUsed = [];
							compareArray = [];
							dropAreas = [];
							dragItems = [];
							seconds = 0, minutes = 0, hours = 0;

							var getWidgets = document.getElementsByClassName("termWidget");
							var droppedTerm = document.getElementsByClassName("droppedTerm");

							for(var i=0; i < 5; i++){
								getWidgets[i].setAttribute("draggable", true);
								droppedTerm[i].innerHTML = "Empty";
								droppedTerm[i].style.backgroundColor = "cyan";
							}
							startRestart();

						}//end myBt.onclick that restarts the game
					}

				}//end third onclick that changes button to "Play again"

			}//end second myBtn.onclick that changes button to show score

		}//end first myBtn.onclick


		undoBtn.onclick = function(){

			var tempObject = undoArray.pop();

			//this puts the term back into the draggable spot
			tempObject.term.innerHTML = tempObject.answer.innerHTML;

			//this changes the answer box back to "Empty"
			tempObject.answer.innerHTML = "Empty";
			tempObject.term.draggable = "true";

			console.log("undoArray.length: " + undoArray.length);
			//makes button invisible if undo before the first move
			if(undoArray.length == 0){
				undoBtn.style.visibility = 'hidden';
			}

		}//end undoBtn.onclick

	}//end playplay

	play();

});