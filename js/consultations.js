
function openTab(evt, tabName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}

function clicAccepter(){

document.getElementById('refuser').disabled = true;
document.getElementById('accept').disabled = true;
document.getElementById('clientPrisCharge').disabled = false;
}
function clicRefuser(){

document.getElementById('refuser').disabled = true;
document.getElementById('accept').disabled = true;
document.getElementById('clientPrisCharge').disabled = true;
}

function generatePrediction(){
}

function clientPrisEnCharge(){
document.getElementById('chargeClient').style.visibility = 'visible';
document.getElementById('clientPrisCharge').disabled = true;

}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();