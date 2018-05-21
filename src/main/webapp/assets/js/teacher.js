//班级档案
var span=$('.thealthManage ul li>div div span');
var h2=parseFloat($('.thealthManage ul li>div h2').html())
console.log($('.thealthManage ul li>div h2').html())
for(var i= 0,h2;i<span.length;i++){
    console.log($(span[i]).css('width'))
    $(span[i]).css('width',parseFloat($(span[i]).parent().prev().html())+'%');
    if(parseFloat(span[i].style.width)<50){
        span[i].style.backgroundColor='#f00';
    }
}
