jQuery(document).ready(function($) {
	$.fn.api.settings.api = {
		'test' : 'dp/test?flg={/flg}'
	};

	$('.ui.checkbox').checkbox();

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