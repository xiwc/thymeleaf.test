
// fancybox slide show test
jQuery(document).ready(function($) {
	
	$('.fancybox').fancybox();
	
	// Button helper. Disable animations, hide close button, change title type and content
	$('.fancybox-buttons').fancybox({
		openEffect  : 'none',
		closeEffect : 'none',

		prevEffect : 'none',
		nextEffect : 'none',

		closeBtn  : false,

		helpers : {
			title : {
				type : 'inside'
			},
			buttons	: {}
		},

		afterLoad : function() {
			this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
		}
	});
	
	// Thumbnail helper. Disable animations, hide close button, arrows and slide to next gallery item if clicked
	$('.fancybox-thumbs').fancybox({
		prevEffect : 'none',
		nextEffect : 'none',

		closeBtn  : false,
		arrows    : false,
		nextClick : true,

		helpers : {
			thumbs : {
				width  : 50,
				height : 50
			}
		}
	});

});

// toastr test
jQuery(document).ready(function($) {
	
	toastr.options = {
			  "closeButton": true,
			  "debug": false,
			  "newestOnTop": true,
			  "progressBar": false,
			  "positionClass": "toast-bottom-center",
			  "preventDuplicates": false,
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			  "showEasing": "swing",
			  "hideEasing": "linear",
			  "showMethod": "fadeIn",
			  "hideMethod": "fadeOut"
			};
	
	$('.ts-show-notification').click(function(){
		// success info warning error
		toastr['info']("msg...", "title");
	});
});

// dropzone file uploader
jQuery(document).ready(function($) {
	Dropzone.options.myDropzone = {
			  paramName: "multiple", // The name that will be used to transfer the file
			  maxFilesize: 50 // MB
	};
});

// html5 file uploader
jQuery(document).ready(function($) {
	
	$('.ts-upload').bind("dragenter dragover", function(){
		$('.ts-upload .dimmer').dimmer('show').find('.text').text('Drop to Upload');
	}).bind("dragleave", function () {
		$('.ts-upload .dimmer').dimmer({
			duration: {
				  hide : 500
				}
			}).dimmer('hide');
    });
	
	$("#dropbox, #multiple").html5Uploader({
		name : "multiple",
		postUrl : "page/upload",
		onClientLoadStart : function(e, file) {
			
			$('.ts-upload .dimmer').dimmer('show').find('.text').text('Uploading...');
			
//			var filter = /^(image\/bmp|image\/gif|image\/jpeg|image\/png|image\/tiff)$/i;
//			if (!filter.test(file.type)) {
//				e.preventDefault();
//				e.stopPropagation();
//				$('.ts-upload .dimmer').dimmer({
//					duration: {
//						  hide : 3000
//						}
//					}).dimmer('hide').find('.text').text('Unsupport file type');
//			}
		},
		onServerProgress : function(e, file) {
			if (e.lengthComputable) {
				var percentComplete = parseInt((e.loaded / e.total) * 100);
				$('.ts-upload .dimmer').find('.text').html('Uploading...</br></br>Finished: ' + percentComplete + '%');
			}
		},
		onServerError : function(e, file) {
			$('.ts-upload').dimmer({
				duration: {
					  hide : 3000
					}
				}).dimmer('hide');
		},
		onSuccess : function(e, file, msg) {
			var resp = $.parseJSON(msg);
			if (resp.success) {
				$('.ts-upload .dimmer').dimmer({
					duration: {
						  hide : 3000
						}
					}).dimmer('hide').find('.text').text('Upload Success!');
			} else {
				$('.ts-upload .dimmer').dimmer({
					duration: {
						  hide : 3000
						}
					}).dimmer('hide').find('.text').text(resp.message);
			}
		}
	});
});

// semantic-ui test
jQuery(document).ready(function($) {
	
	$.fn.api.settings.api = {
		'test' : 'dp/test?flg={/flg}'
	};

	$('.ui.checkbox').checkbox();
	
	$('.ui.accordion').accordion();
	
	$('.ts-clear-log').click(function(){
		$('.ts-message ul').empty();
	});
	
	$('.ts-list-all').click(function(){
		$.get("dp/test").done(function(resp){
			console.log(JSON.stringify(resp));
		});
	});
	
	$('.ts-submit').click(function(){
		$('.ts-form').parents('form').submit();
	});
	
	$('.ts-table').tablesort();

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

// jQuery Deferred & Callbacks test
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
