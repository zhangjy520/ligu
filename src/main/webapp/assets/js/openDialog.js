	//弹出tips  
	/*layer.tips(html, this, {
			  tips: [2, '#1ab394']
			});
*/
	//参数是在哪个html元素上显示这个tips
	function showScore(obj){
	/*var html="";
		var target=$(obj).attr("id").replace("xszf","scores");
		html=$("#"+target).html();
		*/
		layer.tips("内容在openDialog.js里面修改", obj, {
		  tips: [3, '#1ab394']   //1上面弹出 2默认右边 3下面 4 左边
		});

	
	}

	//打开对话框(添加修改)
		function openDialog(title,url,width,height,target){
			layer.open({
			    type: 2,  
			    area: [width, height],
			    title: title,
		        maxmin: false, //开启最大化最小化按钮
			    content: url ,
			    btn: ['确定', '关闭'],
			    yes: function(index, layero){
			    	var body = top.layer.getChildFrame('body', index);
					var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
					var inputForm = body.find('#inputForm');
					var top_iframe;
					/*if(target){
						top_iframe = target;//如果指定了iframe，则在改frame中跳转
					}
					inputForm.attr("target",top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示*/

					if(iframeWin.contentWindow.doSubmit() ){

						setTimeout(function(){parent.location.reload();}, 300);/*刷新父级页面,延迟保证页面刷新的时候数据已经更新完毕*/

						setTimeout(function(){top.layer.close(index)}, 100);//延时0.1秒，对应360 7.1版本bug
					}
				  },
				  cancel: function(index){
					  top.layer.close(index);
			       }
			}); 	
		}
		
		
		
		/*导入失败弹出框*/
		function importFail(width,height){
					
						var html = '<div class="upLoadFail"><div class="alertDivHeader"><label>导入失败</label></div><div class="alertDivContent"><label>可能原因如下：</label><br><br><div class="alertReason">1.上传文件格式不是excel格式。<br><br>2.上传的表格有合并的单元格。<br><br>3.上传的必填内容不完整。</div><div class="alertButtons"><input type="button" onclick="closeAlertDiv()" value=" 取消 "/><input type="button" value=" 重新上传 "/></div></div></div>';

						//页面层-自定义
						layer.open({
							type: 1,
							area: [width, height],
							title: false,
							closeBtn: 0,
							shadeClose: true,
							skin: 'yourclass',
							content: html
						});
				
		}

		/*普通的内容提示框*/
		function alertTips(width,height,title,content,clickUrl){
					
		     var html = '<div class="" style="height:'+height+';width:'+width+'"><div class="alertDivHeader"><label>'+title+'</label></div><div class="alertDivContent"><label>'+content+'</label><br><br><div class="alertButtons"><input type="button" onclick="closeAlertDiv()" value=" 取消 " /><input type="button" value=" 确定 " onclick="'+clickUrl+'" /></div></div></div>';
						//页面层-自定义
						layer.open({
							type:1,
							area: [width, height],
							title: false,
							closeBtn: 0,
							shadeClose: true,
							skin: 'yourclass',
							content: html
						});
				
		}
		
		function closeAlertDiv() {
			layer.closeAll();
		}