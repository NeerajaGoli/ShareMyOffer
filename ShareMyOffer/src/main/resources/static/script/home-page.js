function showDetails(i) {
    console.log(i);
	var offer = document.getElementById(i);
	if (offer.style.display === "none") {
		offer.style.display = "block";
	} else {
		offer.style.display = "none";
	}
}

function searchOffers(){
	var searchElement = document.getElementById("searchOffer");
	var input = searchElement.value.toUpperCase();
	var ul = document.getElementById("myTableContents");
	var li = ul.getElementsByTagName("li");
	for(var i=0;i<li.length;i++) {
		var h3 = li[i].getElementsByTagName("h3");
		var p = li[i].getElementsByTagName("p");
		var span = li[i].getElementsByTagName("span");
		if(h3[0].innerHTML.toUpperCase().indexOf(input) > -1 ||
		   p[0].innerHTML.toUpperCase().indexOf(input) > -1) {
			li[i].style.display = "";
		}
		else {
			li[i].style.display = "none";
		}
	}
}
