// 用于存放一些通用变量
var ctx = window.location.protocol +"//"+ window.location.host;
var ctxApp = window.location.protocol +"//"+ window.location.host+"/tsapp";

// JavaScript Document
$(function(){
$('.forder li a').click(function(){	
	$(this).addClass('acver').parents('li').siblings().find('a').removeClass('acver')	
})
$('.app_Guest li').click(function(){
	$(this).addClass('avcet').siblings().removeClass('avcet')	
})

$('.khlst').click(function(){
	layer.open({
    title: false
    ,className:'aopn'
    ,content:$('#jinof').html()
 });
})
$('body').on('click','.nodet',function(){
	
	layer.closeAll()
})
/*搜索遮罩层*/

var bodyheight= $(window).height()

var bodywidth= $(window).width()

$('.Mask').width(bodywidth)

$('.Mask').height(bodyheight-90+'px')

$('.Mask1').width(bodywidth)

$('.Mask1').height(bodyheight)

$('.web_sku').height(bodyheight)


$('.mindor_3').click(function(){
	$(this).css('background-image','url(img/sx_xz.png)')
	$('.Mask1').show()
	$('.web_sku').css('right','0')
	$('.Mask').hide()
	$('.web_Price').hide()
	$('.web_Star').hide()
})
$('.aist').click(function(){
	$('.Mask1').hide()
	$('.web_sku').css('right','-100%')
	
})

$('.hist').click(function(){
	layer.open({
    content: '领取成功'
    ,skin: 'msg'
    ,time: 2 //2秒后自动关闭
 });
})

$('body').on('click','.onctor_a',function(){
	
	layer.closeAll()
})


$('body').on('click','.remsint',function(){
	$(this).parents('.Occupant').remove()
})

$('.biem_cont').click(function(){
	$(this).addClass('biatacve').siblings().removeClass('biatacve')
	
})

/*收藏*/
$('body').on('click','.like',function(){
	if($(this).hasClass('j')){
		$(this).attr('src','static/img/xi02@2xx.png')   
	    $(this).removeClass('j')
	}else{
		$(this).attr('src','static/img/xi01@2xx.png')
	    $(this).addClass('j')
	}		
}) 
	 










//通用提示框
$(".spoert").click(function(){
	var msg = $(this).attr("msg-tite")
	layer.open({	
	className:'smtn',
    content: msg
    ,btn: ['确认', '取消']
    ,skin: 'footer'
    ,yes: function(index){	
     layer.open({
    content: '提交成功'
    ,skin: 'msg'
    ,time: 2 //2秒后自动关闭
  });
    }
  });		
})	




})



/**
 * 获得url参数中名称的值
 * @param name
 * @returns
 */
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}

function fmtDate(obj){
    var date =  new Date(obj);
    var y = 1900+date.getYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}












