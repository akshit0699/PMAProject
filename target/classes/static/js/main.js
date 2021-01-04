var chartData =  JSON.parse(decodeHtml(chartData)) ;

var nuemericData = []
var labelData = []

for(var i = 0; i<chartData.length; i++){
    nuemericData[i] = chartData[i].value;
    labelData[i] = chartData[i].label;
}

new Chart(document.getElementById("myPieChart"),{
    type: 'doughnut',

    data: {
        datasets: [{
            data: nuemericData,
            backgroundColor: ["#962b2b", "#F7EC3F", "#FF7CBF"],
            
        }],
    
        // These labels appear in the legend and in the tooltips when hovering different arcs
        labels: labelData
    },

    options: {
        title:{
            display: true,
            text: 'Project Statuses'
        }
    }
});

function decodeHtml(html){
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}