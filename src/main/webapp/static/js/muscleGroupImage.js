




	var word = document.getElementById("plz").textContent="${tempMuscleGroup.name}";
	console.log(word);
if (word=="Abdominals"){
	document.getElementById("imageId").src="/static/images/abs.jpg";
   console.log("abs worked")
}
if (word=="Biceps"){
    document.getElementById("imageId").src = "/static/images/bicep.jpg";
    console.log("biceps worked")
}
if (word=="Calves"){
    document.getElementById("imageId").src = "/static/images/calves.jpg";
  
}
if (word=="Chest"){
	document.getElementById("imageId").src="/static/images/chest.jpg";
  
}
if (word=="Forearms"){
    document.getElementById("imageId").src = "/static/images/forearms.jpg";
}
if (word=="Quads"){
    document.getElementById("imageId").src = "/static/images/quads.jpg";
  
}
if (word=="Shoulders"){
    document.getElementById("imageId").src = "/static/images/shoulder.jpg";
}
if (word=="Traps"){
    document.getElementById("imageId").src = "/static/images/traps.jpg";
  
}
