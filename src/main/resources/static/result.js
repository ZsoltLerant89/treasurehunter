window.onload = function(){
	blink();
}

	function blink() {
	   let loseElement = document.getElementById('lose');
	   let winElement = document.getElementById('win');
	   
	   	if(loseElement != null)
		{
		   setInterval(function() {
		      loseElement.style.display = (loseElement.style.display == 'none' ? '' : 'none');
		   }, 1000);
	   	}
	   
		if(winElement != null)
		{
	   	   setInterval(function() {
	   	      winElement.style.display = (winElement.style.display == 'none' ? '' : 'none');
	   	   }, 1000);
		}
	}
