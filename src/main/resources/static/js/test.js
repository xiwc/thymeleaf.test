jQuery(document).ready(function($) {
	
	$.fn.api.settings.api = {
		'test' : 'dp/test?flg={/flg}'
	};

	$('.ui.checkbox').checkbox();
	$('.ui.accordion').accordion();
	$('.ts-clear-log').click(function(){
		$('.ts-message ul').empty();
	});

	$('.ts-search').api({
		action : 'test',
		beforeSend : function(settings) {
			settings.urlData = {
				flg : $('.ts-flg').checkbox('is checked')
			};
			return settings;
		},
		successTest : function(response) {
			console.log('successTest' + response);
			return response.success || false;
		},
		onSuccess : function(response, element) {
			// valid response and response.success = true
			console.log('onSuccess' + response);
		},
		onFailure : function(response, element) {
			// valid response but response.success = false
			console.log('onFailure' + response);
		},
		onError : function(errorMessage, element) {
			// invalid response
			console.log('onError' + errorMessage);
		},
		onAbort : function(errorMessage, element) {
			// user cancelled request
			console.log('onAbort' + errorMessage);
		},
		onComplete : function(response, element) {
			// user cancelled request
			console.log('onComplete' + response);
		}
	});
});

jQuery(document).ready(function($) {
	
	$.get("dp/test").done(function(resp){
		console.log(JSON.stringify(resp));
	});
	
	
	var d = (function(){
		
		var d = jQuery.Deferred();
		
		setTimeout(function(){
			d.resolve({success:true});
		}, 5000);
		
		return d.promise();
		
	})();
	
	d.done(function(resp){
		console.log(JSON.stringify(resp));
	});
	
	console.log("...");
	
	// ----------------------------------------------
	
	/**
	 * var c = jQuery.Callbacks(flags);
	 * 可用的 flags: 
		once: 确保这个回调列表只执行一次(像一个递延 Deferred). 
		memory: 保持以前的值和将添加到这个列表的后面的最新的值立即执行调用任何回调 (像一个递延 Deferred). 
		unique: 确保一次只能添加一个回调(所以有没有在列表中的重复). 
		stopOnFalse: 当一个回调返回false 时中断调用,默认情况下，回调列表将像事件的回调列表中可以多次触发。
	 */
	var c = jQuery.Callbacks();
	
	c.add(function(val){
		console.log("1:" + val);
	});
	
	c.fire('test callbacks');
	
	//c.empty();
	//c.disable();
	//c.lock();
	//c.has(function(){});
	//c.remove(function(){});
	
	c.add(function(val){
		console.log("2:" + val);
	}).add(function(val){
		console.log("3:" + val);
	});
	
	c.fire('test callbacks');
});

// override console.log function.

var console = console || {};

jQuery.extend(console, {
	log:function(msg){
		$('<li/>').text(msg).appendTo('.ts-message ul');
	}
});
