let life = 2;
let win = false;
let clicked = 0;

window.onload = function(){
	init();
	
	let elements = document.getElementsByClassName("column");
	
		for(let index = 0; index < elements.length; index++)
		{
			let currentElement = elements[index];
			
			currentElement.onclick = function()
			{
				clickHandler(currentElement);
			}	
		}	
}


function init(){
	let treasure = 0;
	let skull1 = 0;
	let skull2 = 0;
	
	treasure = Math.floor(Math.random()*24);
	
	do
	{
		skull1 = Math.floor(Math.random()*24);	
	}while(skull1 == treasure);
	
	do
	{
		skull2 = Math.floor(Math.random()*24);
	}while((skull2 == treasure) || (skull2 == skull1));
	
	let elements = document.getElementsByClassName("column");
	
	elements[treasure].classList.add("treasure"); 
	elements[skull1].classList.add("skull"); 
	elements[skull2].classList.add("skull"); 
	
}

function clickHandler(currentElement)
{
	if((life > 0) && (win == false))
	{
		let winElement = document.getElementById("winId");
		let clickedIdElement = document.getElementById("clickedFromId");
		
		let clickedElement = document.getElementById("clicked");
		
		clicked++;
				
		if(clickedElement != null)
		{
			clickedElement.innerHTML = "Clicked: " + clicked;
		}

		if(currentElement.classList.contains("treasure") == true )
		{
			currentElement.classList.add("treasureBuild");
			win = true;
			
			if(winElement != null)
			{	
				winElement.value = 1 ;
				
				clickedIdElement.value = clicked;
				
				let myTimeout = setTimeout(goToResultHtml,1000);
				
			}
		}
		else if(currentElement.classList.contains("skull") == true )
		{
			currentElement.classList.add("skullBuild");
			life--;

			if(life < 1 )
			{
				
				winElement.value = 0;
					
				clickedIdElement.value = clicked;
				
				let myTimeout = setTimeout(goToResultHtml,1000);
				
			}
			
		}
		else
		{
			currentElement.style.backgroundImage = "none";
			currentElement.style.backgroundColor = "gray";
		}
		
	}
}

function goToResultHtml()
{
	let submitElement = document.getElementById("submitId");
	submitElement.click();
}

function stopFunction()
{
	clearTimeout(myTimeout);
}
