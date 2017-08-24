/*
					//初始化表样数据
					$(function() {
						var car; //学生对象
						var pageSize = 3; //每页显示多少条数据
						var pageCount = $("#pageCount").val(); //总记录数
						var pageNow = 1; //当前面，默认为第一页
						var start = 0; //开始位置
						pages(start, pageSize * pageNow, pageSize);
				
				
						//分页延迟加载
						setTimeout(function() {
							$(".tcdPageCode").createPage({
								pageCount : pageCount,
								current : 1,
								backFn : function(p) { //p 是当前选中的页
									//console.log(p);
									var end = pageSize * p; //结束位置
									pageNow = (p - 1) * pageSize; //开始位置
									jsons(car, pageNow, end);
								}
							});
						}, 900)
				
					});
				
					function recordCount(pageCount, pageSize) { //计算总页数
						var count = pageCount / pageSize;
						if (pageCount % pageSize != 0) {
							count = parseInt(pageCount / pageSize) + 1;
						}
						return count;
					}
					//添加面板
					var index = 0;
					function addPanel() {
						index++;
						$('#tt1').tabs('add', {
							title : 'Tab' + index,
							content : '<div style="padding:10px">Content' + '<input id="dd" type="text" class="easyui-datebox" value="3/4/2010" required="required">' + '</div>',
							closable : true
						});
					}
				
					//删除面板
					function removePanel() {
						var tab = $('#tt1').tabs('getSelected');
						if (tab) {
							var index = $('#tt1').tabs('getTabIndex', tab);
							if (index == 0)
								return false;
							$('#tt1').tabs('close', index);
						}
					}
				
				
				
					//p 当前页、end 结束位置
					function pages(p, end, pageSize) {
						$.getJSON("car!carInfo.action",function(data){
							var count = recordCount(data.length, pageSize); //计算总记录数
							$("#pageCount").val(count);
							pageCount = count;
							car = data;
							jsons(data, p, end);
						});
					};
				
					//stu 集合对象、start 开始位置、end 结束位置
					function jsons(data, start, end) {
						//表格填充数据
						if(data.length < end) {//判断结束位置是否大于集合长度
							end = data.length;
						}
						var html = "";
						for(var i = start ; i < end ; i++) {
							html += "<tr><td>"+data[i].ctype+"</td><td>"+data[i].cname+"</td><td>"+data[i].ccolor+"</td><td>"+data[i].cprice+"</td><td>"+data[i].ccard+"</td><td>"+data[i].cstatus+"</td><td><a href='#')\">删除</a></td></tr>";
						}
						$("#tb").html(html);
					}*/