
$('.time_tool span').click(function(){
    $(this).addClass('current').siblings().removeClass('current')
})

$('.radio input').change(function(){

    if(this.id=='duration'||this.id=='sleep'){
        $('.tag').html('小时/班级')
    }
    if(this.id=='fallsleep'){
        $('.tag').html('时间/班级')
    }
})

//$('.menu_main li a').mouseover(function(){
//    $(this).next().slideDown('fast');
//
//})
//$('.menu-box').mouseover(function(){
//    console.log(this)
//    $(this).prev().addClass('active');
//})
//$('.menu-box').mouseout(function(){
//
//    console.log(this)
//    $(this).prev().removeClass('active');
//    //$(this).slideUp('fast');
//})
$('.menu_main li').hover(function(){


        $(this).find('.menu-box').show();

},function(){
    $(this).find('.menu-box').slideUp('fast')
})
$('.menu-box').hover(function(){
    $(this).prev().addClass('active');
},function(){
    $(this).prev().removeClass('active');
})



//
//$('.healthManage table td:last-child span').click(function(){
//    $('.module').css('display','block')
//})
$('.module input[type=reset]').click(function(){
    $('.module').css('display','none')
})
$('.add').click(function(){
    $('.module1').show();
})
$('.xiugai').click(function(){
    $('.module2').show();
})
$('.module1 input[type=reset]').click(function(){
    $('.module1').css('display','none')
})
$('.module2 input[type=reset]').click(function(){
    $('.module2').css('display','none')
})
$('.detail ul.grade li span').click(function(){
    $('.detail ul.grade li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.class li span').click(function(){
    $('.detail ul.class li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.date li span').click(function(){
    $('.detail ul.date li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.date li span').click(function(){
    $('.detail ul.date li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.block li span').click(function(){
    $('.detail ul.block li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.project li span').click(function(){
    $('.detail ul.project li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.order li span').click(function(){
    $('.detail ul.order li span').removeClass('active');
    $(this).addClass('active');
})
$('.detail ul.test-time li span').click(function(){
    $('.detail ul.test-time li span').removeClass('active');
    $(this).addClass('active');
})


$('.position table td:last-child span').click(function(){
    $('section.jkDetail').show();
    $('section.jkAll').hide();
})
$('.baseStuMsg p .import').click(function(){
    $('.module').css('display','block');
})
$('.importMsg').click(function(){
    $('.msgImport').css('display','block');
})

//手环临时管理
$('.guashi').click(function(){
    $('.gsPop').show();
})
$('.temporary td:last-child span.chakan').click(function(){
    $('.shCondition').show();
})
$('.popFoot input[type=reset]').click(function(){
    $(this).parent().parent().parent().hide();
});

$('.bindTem').click(function(){
    $('.gsPop').hide();
    $('.TemBind').show();
})
$('.popFoot input[type=submit]').click(function(){
    $(this).parent().parent().parent().hide();
})
$('.bindNew').click(function(){
    $('.gsPop').hide();
    $('.newBind').show();
})
$('.bindNew1').click(function(){
    $('.confirm').hide();
    $('.newBind').show();
})
$('.gsremove').click(function(){
    $('.removeGs').show();
})

$('.diushi').click(function(){
    $('.confirm').show();
})

//基站管理
$('.roleAdd').click(function(){
    $('.changeRole').show();
})
$('.role .alter').click(function(){
    $('.alterRole').show();
})

//手环管理
$('.release').click(function(){
    $('.releaseBind').show();
})
$('.bindNew2').click(function(){
    $('.releaseBind').hide();
    $('.newBind').show();
})
$('.onLost').click(function(){
    $('.TemBind').show();
})


//校区管理
$('.blockAdd').click(function(){
    $('.addBlock').show();
})
$('.alter1').click(function(){
    $('.editBlock').show();
})

$('.close').click(function(){
    $('.imgBlock').hide();
})
$('.preview').click(function(){
    $('.imgBlock').show();
})

//教师管理
$('.roles input').change(function(){
    if(this.id=='role4'){
        $('.classManage').show();
    }else{
        $('.classManage').hide()
    }
})
$('.teacherAdd').click(function(){
    $('.addTeacher').show();
})
$('.alter2').click(function(){
    $('.editTeacher').show();
})

//导出文件
$('.excel').click(function(){
    $('.importConfirm').show();
})

//成绩管理
$('.change').click(function(){
    $('.Change').show();
})






























