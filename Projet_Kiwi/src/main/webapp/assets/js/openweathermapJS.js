const API_KEY = "c304746a4fc53ccbc8ee06581daa93e6";

const weathers = ['Java', 'Paris', 'Oran'];
const cities = ['Jakarta', 'Paris', 'Oran'];
const countryKeyWords = ['indonesie', 'france', 'algerie'];
const continentKeyWords = ['oceanie', 'europe', 'afrique'];

const nbCities = weathers.length;
const delay = 1000;
let index = 0;


$(document).ready(function(){
	setInterval(changeWeather, 3000);
})

function changeWeather(){
	    var city = cities[index];
	    
        $.ajax({
            url: "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric" + "&appid=" + API_KEY,
            type: "GET",
            dataType: "jsonp",
            success: function(data){
                show(data);
                index = index+1 < nbCities ? index+1 : 0;
            }
        });
        
}




function show(data){
    res =  "<div class='place'>"+ "Meteo de " + weathers[index] + ", "+ countryKeyWords[index] +"</div>"
    	+ "<div class='temperature'>Température: "+ data.main.temp +" °C </div>"
    	+ "<div class='weather'>"+ data.weather[0].description +"</div>"
    	+ "<img class='weather-icon' src='http://openweathermap.org/img/wn/" + data.weather[0].icon + "@2x.png'/><br/>"
    	+ "<a class=\"btn btn-lg btn-default\" href=\"travels/filters?pCountry="+countryKeyWords[index]+"\" role='button'>Voir les voyages correspondants</a> ";
    $('#displayedWeather').html(res);
}