$(function() {
	google.charts.load('current', {'packages':['corechart','corechart']});

    google.charts.setOnLoadCallback(function () {
  	  drawChart1();
  	  drawChart2();
  	  drawChart3();
  	  drawChart4();
  	  drawChart5();
    });
    setInterval(drawChart2, 5000);
    setInterval(drawChart3, 6000);
    setInterval(drawChart4, 7000);
    setInterval(drawChart5, 8000);
});
function drawChart1() {
		var jsonData = $.ajax({
              type:"GET",
              url : "http://localhost:8080/Onwine-BigData/products/typesChartData",
              dataType: 'json',
              crossDomain: true,
              async: false 
          }).responseText;
        var data = new google.visualization.DataTable(jsonData);
        var options = {'title':'Répartition des types de vin provisionnés',
        				is3D:true,
                       'width':600,
                       'height':300};
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
}
function drawChart2() {
	 var jsonData = $.ajax({
         type:"GET",
         url : "http://localhost:8080/Onwine-BigData/orders/currenciesChartData",
         dataType: 'json',
         crossDomain: true,
         async: false 
     }).responseText;
   var data = new google.visualization.DataTable(jsonData);
   var options = {'title':'Répartition des devises utilisées',
   				is3D:true,
                  'width':600,
                  'height':300};
   var chart = new google.visualization.BarChart(document.getElementById('chart_div2'));
   chart.draw(data, options);
}
function drawChart3() {
	var jsonData = $.ajax({
          type:"GET",
          url : "http://localhost:8080/Onwine-BigData/orders/countriesChartData",
          dataType: 'json',
          crossDomain: true,
          async: false 
      }).responseText;
    var data = new google.visualization.DataTable(jsonData);
    var options = {'width':1200,
            'height':700};
    var chart = new google.visualization.GeoChart(document.getElementById('chart_div3'));
    chart.draw(data, options);
}
function drawChart4() {
	var jsonData = $.ajax({
          type:"GET",
          url : "http://localhost:8080/Onwine-BigData/orders/typesChartData",
          dataType: 'json',
          crossDomain: true,
          async: false 
      }).responseText;
    var data = new google.visualization.DataTable(jsonData);
    var options = {'title':'Répartition des types de vin commandés',
    				pieHole:0.4,
                   'width':600,
                   'height':300};
    var chart = new google.visualization.PieChart(document.getElementById('chart_div4'));
    chart.draw(data, options);
}
function drawChart5() {
	 var jsonData = $.ajax({
        type:"GET",
        url : "http://localhost:8080/Onwine-BigData/orders/topProductsChartData",
        dataType: 'json',
        crossDomain: true,
        async: false 
    }).responseText;
  var data = new google.visualization.DataTable(jsonData);
  /*var view = new google.visualization.DataView(data);
  view.setColumns([0, 1,
                   { calc: "stringify",
                     sourceColumn: 1,
                     type: "string",
                     role: "annotation" },
                   2]);*/

  var options = {'title':'Top 10 des ventes',
  				is3D:true,
                 'width':600,
                 'height':300};
  var chart = new google.visualization.ColumnChart(document.getElementById('chart_div5'));
  chart.draw(data, options);
}