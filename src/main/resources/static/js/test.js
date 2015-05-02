// bootstrap-markdown test
$(document).ready(function() {
	$("#ts-textarea-markdown").markdown({
		language:'zh'
	});
});

// ckeditor test
$(document).ready(function() {
	$('#ts-textarea-ckeditor').ckeditor();
});

// wysiwyg Editor test
jQuery(document).ready(function($) {
    var index = 0;
    var element = '#ts-textarea-wysiwyg';
    $(element).wysiwyg({
        classes: '',
        // 'selection'|'top'|'top-selection'|'bottom'|'bottom-selection'
        toolbar: index == 0 ? 'top-selection' : (index == 1 ? 'bottom' : 'selection'),
        buttons: {
            smilies: {
                title: '表情',
                image: '\uf118',
                popup: function($popup, $button) {
                    var list_smilies = ['<img src="lib/wysiwyg/smiley/afraid.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/amorous.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/angel.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/angry.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/bored.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/cold.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/confused.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/cross.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/crying.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/devil.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/disappointed.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/dont-know.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/drool.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/embarrassed.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/excited.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/excruciating.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/eyeroll.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/happy.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/hot.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/hug-left.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/hug-right.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/hungry.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/invincible.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/kiss.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/lying.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/meeting.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/nerdy.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/neutral.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/party.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/pirate.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/pissed-off.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/question.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/sad.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/shame.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/shocked.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/shut-mouth.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/sick.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/silent.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/sleeping.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/sleepy.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/stressed.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/thinking.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/tongue.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/uhm-yeah.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/wink.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/working.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/bathing.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/beer.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/boy.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/camera.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/chilli.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/cigarette.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/cinema.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/coffee.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/girl.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/console.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/grumpy.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/in_love.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/internet.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/lamp.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/mobile.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/mrgreen.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/musical-note.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/music.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/phone.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/plate.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/restroom.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/rose.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/search.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/shopping.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/star.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/studying.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/suit.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/surfing.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/thunder.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/tv.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/typing.png" width="16" height="16" alt="" />', '<img src="lib/wysiwyg/smiley/writing.png" width="16" height="16" alt="" />'];
                    var $smilies = $('<div/>').addClass('wysiwyg-plugin-smilies').attr('unselectable', 'on');
                    $.each(list_smilies, function(index, smiley) {
                        if (index != 0) $smilies.append(' ');
                        var $image = $(smiley).attr('unselectable', 'on');
                        // Append smiley
                        var imagehtml = ' ' + $('<div/>').append($image.clone()).html() + ' ';
                        $image.css({
                            cursor: 'pointer'
                        }).click(function(event) {
                            $(element).wysiwyg('shell').insertHTML(imagehtml); // .closePopup(); - do not close the popup
                        }).appendTo($smilies);
                    });
                    var $container = $(element).wysiwyg('container');
                    $smilies.css({
                        maxWidth: parseInt($container.width() * 0.95) + 'px'
                    });
                    $popup.append($smilies);
                    // Smilies do not close on click, so force the popup-position to cover the toolbar
                    var $toolbar = $button.parents('.wysiwyg-toolbar');
                    if (!$toolbar.length) // selection toolbar?
                        return;
                    return { // this prevents applying default position
                        left: parseInt(($toolbar.outerWidth() - $popup.outerWidth()) / 2),
                        top: $toolbar.hasClass('wysiwyg-plugin-bottom') ? ($container.outerHeight() - parseInt($button.outerHeight() / 4)) : (parseInt($button.outerHeight() / 4) - $popup.height())
                    };
                },
                showstatic: true,
                showselection: true
            },
            insertimage: {
                title: '插入图片',
                image: '\uf030',
                showstatic: true,
                showselection: true
            },
            insertvideo: {
                title: '插入视频',
                image: '\uf03d',
                showstatic: true,
                showselection: true
            },
            insertlink: {
                title: '插入链接',
                image: '\uf08e'
            },
            fontname: index == 1 ? false : {
                title: '字体',
                image: '\uf031',
                popup: function($popup, $button) {
                    var list_fontnames = {
                        // Name : Font
                        '宋体': '宋体',
                        '黑体': '黑体',
                        '楷体': '楷体',
                        '隶书': '隶书',
                        '幼圆': '幼圆',
                        '微软雅黑': '微软雅黑',
                        'Trebuchet MS': 'Trebuchet MS',
                        'Impact': 'Impact',
                        'Comic Sans MS': 'Comic Sans MS',
                        'Arial, Helvetica': 'Arial,Helvetica',
                        'Verdana': 'Verdana,Geneva',
                        'Georgia': 'Georgia',
                        'Courier New': 'Courier New,Courier',
                        'Times New Roman': 'Times New Roman,Times'
                    };
                    var $list = $('<div/>').addClass('wysiwyg-plugin-list').attr('unselectable', 'on');
                    $.each(list_fontnames, function(name, font) {
                        var $link = $('<a/>').attr('href', '#').css('font-family', font).html(name).click(function(event) {
                            $(element).wysiwyg('shell').fontName(font).closePopup();
                            // prevent link-href-#
                            event.stopPropagation();
                            event.preventDefault();
                            return false;
                        });
                        $list.append($link);
                    });
                    $popup.append($list);
                },
                showstatic: true,
                showselection: true
            },
            fontsize: {
                title: '字体大小',
                image: '\uf034',
                popup: function($popup, $button) {
                    // Hack:
                    // http://stackoverflow.com/questions/5868295/document-execcommand-fontsize-in-pixels/5870603#5870603
                    var list_fontsizes = [];
                    for (var i = 8; i <= 11; ++i) list_fontsizes.push(i + 'px');
                    for (var i = 12; i <= 28; i += 2) list_fontsizes.push(i + 'px');
                    list_fontsizes.push('36px');
                    list_fontsizes.push('48px');
                    list_fontsizes.push('72px');
                    var $list = $('<div/>').addClass('wysiwyg-plugin-list').attr('unselectable', 'on');
                    $.each(list_fontsizes, function(index, size) {
                        var $link = $('<a/>').attr('href', '#').html(size).click(function(event) {
                            $(element).wysiwyg('shell').fontSize(7).closePopup();
                            $(element).wysiwyg('container').find('font[size=7]').removeAttr("size").css("font-size", size);
                            // prevent link-href-#
                            event.stopPropagation();
                            event.preventDefault();
                            return false;
                        });
                        $list.append($link);
                    });
                    $popup.append($list);
                },
                showstatic: true,
                showselection: true
            },
            header: {
                title: '标题',
                image: '\uf1dc',
                popup: function($popup, $button) {
                    var list_headers = {
                        // Name : Font
                        '标题 1': '<h1>',
                        '标题 2': '<h2>',
                        '标题 3': '<h3>',
                        '标题 4': '<h4>',
                        '标题 5': '<h5>',
                        '标题 6': '<h6>',
                        '代码': '<pre>'
                    };
                    var $list = $('<div/>').addClass('wysiwyg-plugin-list').attr('unselectable', 'on');
                    $.each(list_headers, function(name, format) {
                        var $link = $('<a/>').attr('href', '#').css('font-family', format).html(name).click(function(event) {
                            $(element).wysiwyg('shell').format(format).closePopup();
                            // prevent link-href-#
                            event.stopPropagation();
                            event.preventDefault();
                            return false;
                        });
                        $list.append($link);
                    });
                    $popup.append($list);
                },
                showstatic: true,
                showselection: true
            },
            bold: {
                title: '粗体 (Ctrl+B)',
                image: '\uf032',
                hotkey: 'b'
            },
            italic: {
                title: '斜体 (Ctrl+I)',
                image: '\uf033',
                hotkey: 'i'
            },
            underline: {
                title: '下划线 (Ctrl+U)',
                image: '\uf0cd',
                hotkey: 'u'
            },
            strikethrough: {
                title: '中划线 (Ctrl+S)',
                image: '\uf0cc',
                hotkey: 's'
            },
            forecolor: {
                title: '字体颜色',
                image: '\uf1fc'
            },
            highlight: {
                title: '背景色',
                image: '\uf043'
            },
            alignleft: {
                title: '左对齐',
                image: '\uf036',
                showstatic: true,
                showselection: true
            },
            aligncenter: {
                title: '居中对齐',
                image: '\uf037',
                showstatic: true,
                showselection: true
            },
            alignright: {
                title: '右对齐',
                image: '\uf038',
                showstatic: true,
                showselection: true
            },
            alignjustify: {
                title: '两端对齐',
                image: '\uf039',
                showstatic: true,
                showselection: true
            },
            subscript: {
                title: '下标',
                image: '\uf12c',
                showstatic: true,
                showselection: true
            },
            superscript: {
                title: '上标',
                image: '\uf12b',
                showstatic: true,
                showselection: true
            },
            indent: {
                title: '增加缩进',
                image: '\uf03c',
                showstatic: true,
                showselection: true
            },
            outdent: {
                title: '减少缩进',
                image: '\uf03b',
                showstatic: true,
                showselection: true
            },
            orderedList: {
                title: '有序列表',
                image: '\uf0cb',
                showstatic: true,
                showselection: true
            },
            unorderedList: {
                title: '无序列表',
                image: '\uf0ca',
                showstatic: true,
                showselection: true
            },
            removeformat: {
                title: '清除格式',
                image: '\uf12d'
            }
        },
        submit: {
            title: '提交',
            image: '\uf00c',
            showstatic: true,
            showselection: true
        },
        // Other properties
        selectImage: '单击选择或者拖拽图片',
        placeholderUrl: 'www.example.com',
        placeholderEmbed: '<embed/>',
        maxImageSize: [2000, 2000],
        onKeyDown: function(key, character, shiftKey, altKey, ctrlKey, metaKey) {
            // E.g.: submit form on enter-key:
            //                         if( (key == 10 || key == 13) && !shiftKey && !altKey && !ctrlKey && !metaKey ) {
            //                           //submit_form();
            //                           return false; // swallow enter
            //                         }
        },
        onKeyPress: function(key, character, shiftKey, altKey, ctrlKey, metaKey) {},
        onKeyUp: function(key, character, shiftKey, altKey, ctrlKey, metaKey) {},
        onAutocomplete: function(typed, key, character, shiftKey, altKey, ctrlKey, metaKey) {
            if (typed.indexOf('@') == 0) // startswith '@'
            {
                var usernames = ['Evelyn', 'Harry', 'Amelia', 'Oliver', 'Isabelle', 'Eddie', 'Editha', 'Jacob', 'Emily', 'George', 'Edison'];
                var $list = $('<div/>').addClass('wysiwyg-plugin-list').attr('unselectable', 'on');
                $.each(usernames, function(index, username) {
                    // don't count first character '@'
                    if (username.toLowerCase().indexOf(typed.substring(1).toLowerCase()) !== 0) return;
                    var $link = $('<a/>').attr('href', '#').text(username).click(function(event) {
                        var url = 'http://example.com/user/' + username,
                            html = '<a href="' + url + '">@' + username + '</a> ';
                        var editor = $(element).wysiwyg('shell');
                        // Expand selection and set inject HTML
                        editor.expandSelection(typed.length, 0).insertHTML(html);
                        editor.closePopup().getElement().focus();
                        // prevent link-href-#
                        event.stopPropagation();
                        event.preventDefault();
                        return false;
                    });
                    $list.append($link);
                });
                if ($list.children().length) {
                    if (key == 13) {
                        $list.children(':first').click();
                        return false; // swallow enter
                    }
                    // Show popup
                    else if (character || key == 8) return $list;
                }
            }
        },
        onImageUpload: function(insert_image) {
            var $form = $(this).attr('name', 'multiple').parents('form').attr('action', 'page/upload').attr('method', 'POST').attr('enctype', 'multipart/form-data');
            $.ajax($form.prop('action'), {
                //data: form.find('textarea').serializeArray(),
                dataType: 'json',
                files: $form.find(':file'),
                iframe: true,
                processData: false
            }).always(function() {
                //form.removeClass('loading');
            }).done(function(resp) {
                console.log(JSON.stringify(resp));
                insert_image(resp.data);
                $form.find(':file').val('');
            });
        },
        forceImageUpload: true, // upload images even if File-API is present
        videoFromUrl: function(url) {
            // Contributions are welcome :-)
            // youtube -
            // http://stackoverflow.com/questions/3392993/php-regex-to-get-youtube-video-id
            var youtube_match = url.match(/^(?:http(?:s)?:\/\/)?(?:[a-z0-9.]+\.)?(?:youtu\.be|youtube\.com)\/(?:(?:watch)?\?(?:.*&)?v(?:i)?=|(?:embed|v|vi|user)\/)([^\?&\"'>]+)/);
            if (youtube_match && youtube_match[1].length == 11) return '<iframe src="//www.youtube.com/embed/' + youtube_match[1] + '" width="640" height="360" frameborder="0" allowfullscreen></iframe>';
            // vimeo - http://embedresponsively.com/
            var vimeo_match = url.match(/^(?:http(?:s)?:\/\/)?(?:[a-z0-9.]+\.)?vimeo\.com\/([0-9]+)$/);
            if (vimeo_match) return '<iframe src="//player.vimeo.com/video/' + vimeo_match[1] + '" width="640" height="360" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>';
            // dailymotion - http://embedresponsively.com/
            var dailymotion_match = url.match(/^(?:http(?:s)?:\/\/)?(?:[a-z0-9.]+\.)?dailymotion\.com\/video\/([0-9a-z]+)$/);
            if (dailymotion_match) return '<iframe src="//www.dailymotion.com/embed/video/' + dailymotion_match[1] + '" width="640" height="360" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>';
            // undefined -> create '<video/>' tag
        }
    }).change(function() {
        if (typeof console != 'undefined'); // console.log( 'change' );
    }).focus(function() {
        if (typeof console != 'undefined'); // console.log( 'focus' );
    }).blur(function() {
        if (typeof console != 'undefined'); // console.log( 'blur' );
    });
});
// wangEditor test
jQuery(document).ready(function($) {
    $('#ts-textarea-wang').wangEditor({
        // '$initContent': ... //配置要初始化的内容
        // 'menuConfig': ... //配置要显示的菜单（其他的隐藏）
        // 'onchange': ... //配置onchange事件
        'uploadUrl': 'page/upload' // 配置上传图片的Url
    });
});
// fancybox slide show test
jQuery(document).ready(function($) {
    $('.fancybox').fancybox();
    // Button helper. Disable animations, hide close button, change title type
    // and content
    $('.fancybox-buttons').fancybox({
        openEffect: 'none',
        closeEffect: 'none',
        prevEffect: 'none',
        nextEffect: 'none',
        closeBtn: false,
        helpers: {
            title: {
                type: 'inside'
            },
            buttons: {}
        },
        afterLoad: function() {
            this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
        }
    });
    // Thumbnail helper. Disable animations, hide close button, arrows and slide
    // to next gallery item if clicked
    $('.fancybox-thumbs').fancybox({
        prevEffect: 'none',
        nextEffect: 'none',
        closeBtn: false,
        arrows: false,
        nextClick: true,
        helpers: {
            thumbs: {
                width: 50,
                height: 50
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
    $('.ts-show-notification').click(function() {
        // success info warning error
        toastr['info']("msg...", "title");
    });
});
// dropzone file uploader
jQuery(document).ready(function($) {
    Dropzone.options.myDropzone = {
        paramName: "multiple", // The name that will be used to
        // transfer the file
        maxFilesize: 50 // MB
    };
});
// html5 file uploader
jQuery(document).ready(function($) {
    $('.ts-upload').bind("dragenter dragover", function() {
        $('.ts-upload .dimmer').dimmer('show').find('.text').text('Drop to Upload');
    }).bind("dragleave", function() {
        $('.ts-upload .dimmer').dimmer({
            duration: {
                hide: 500
            }
        }).dimmer('hide');
    });
    $("#dropbox, #multiple").html5Uploader({
        name: "multiple",
        postUrl: "page/upload",
        onClientLoadStart: function(e, file) {
            $('.ts-upload .dimmer').dimmer('show').find('.text').text('Uploading...');
            // var filter = /^(image\/bmp|image\/gif|image\/jpeg|image\/png|image\/tiff)$/i;
            // if (!filter.test(file.type)) {
            // e.preventDefault();
            // e.stopPropagation();
            // $('.ts-upload .dimmer').dimmer({
            // duration: {
            // hide : 3000
            // }
            // }).dimmer('hide').find('.text').text('Unsupport file type');
            // }
        },
        onServerProgress: function(e, file) {
            if (e.lengthComputable) {
                var percentComplete = parseInt((e.loaded / e.total) * 100);
                $('.ts-upload .dimmer').find('.text').html('Uploading...</br></br>Finished: ' + percentComplete + '%');
            }
        },
        onServerError: function(e, file) {
            $('.ts-upload').dimmer({
                duration: {
                    hide: 3000
                }
            }).dimmer('hide');
        },
        onSuccess: function(e, file, msg) {
            var resp = $.parseJSON(msg);
            if (resp.success) {
                $('.ts-upload .dimmer').dimmer({
                    duration: {
                        hide: 3000
                    }
                }).dimmer('hide').find('.text').text('Upload Success!');
            } else {
                $('.ts-upload .dimmer').dimmer({
                    duration: {
                        hide: 3000
                    }
                }).dimmer('hide').find('.text').text(resp.data);
            }
        }
    });
});
// semantic-ui test
jQuery(document).ready(function($) {
    $.fn.api.settings.api = {
        'test': 'dp/test?flg={/flg}'
    };
    $('.ui.checkbox').checkbox();
    $('.ui.accordion').accordion();
    $('.ts-clear-log').click(function() {
        $('.ts-message ul').empty();
    });
    $('.ts-list-all').click(function() {
        $.get("dp/test").done(function(resp) {
            console.log(JSON.stringify(resp));
        });
    });
    $('.ts-submit').click(function() {
        $('.ts-form').parents('form').submit();
    });
    $('.ts-table').tablesort();
    $('.ts-search').api({
        action: 'test',
        beforeSend: function(settings) {
            settings.urlData = {
                flg: $('.ts-flg').checkbox('is checked')
            };
            return settings;
        },
        successTest: function(response) {
            console.log('successTest' + response);
            return response.success || false;
        },
        onSuccess: function(response, element) {
            // valid response and response.success = true
            console.log('onSuccess' + response);
        },
        onFailure: function(response, element) {
            // valid response but response.success = false
            console.log('onFailure' + response);
        },
        onError: function(errorMessage, element) {
            // invalid response
            console.log('onError' + errorMessage);
        },
        onAbort: function(errorMessage, element) {
            // user cancelled request
            console.log('onAbort' + errorMessage);
        },
        onComplete: function(response, element) {
            // user cancelled request
            console.log('onComplete' + response);
        }
    });
});
// jQuery Deferred & Callbacks test
jQuery(document).ready(function($) {
    $.get("dp/test").done(function(resp) {
        console.log(JSON.stringify(resp));
    });
    var d = (function() {
        var d = jQuery.Deferred();
        setTimeout(function() {
            d.resolve({
                success: true
            });
        }, 5000);
        return d.promise();
    })();
    d.done(function(resp) {
        console.log(JSON.stringify(resp));
    });
    console.log("...");
    // ----------------------------------------------
    /**
     * var c = jQuery.Callbacks(flags); 可用的 flags: once: 确保这个回调列表只执行一次(像一个递延
     * Deferred). memory: 保持以前的值和将添加到这个列表的后面的最新的值立即执行调用任何回调 (像一个递延 Deferred).
     * unique: 确保一次只能添加一个回调(所以有没有在列表中的重复). stopOnFalse: 当一个回调返回false
     * 时中断调用,默认情况下，回调列表将像事件的回调列表中可以多次触发。
     */
    var c = jQuery.Callbacks();
    c.add(function(val) {
        console.log("1:" + val);
    });
    c.fire('test callbacks');
    // c.empty();
    // c.disable();
    // c.lock();
    // c.has(function(){});
    // c.remove(function(){});
    c.add(function(val) {
        console.log("2:" + val);
    }).add(function(val) {
        console.log("3:" + val);
    });
    c.fire('test callbacks');
});
// override console.log function.
var console = console || {};
jQuery.extend(console, {
    log: function(msg) {
        $('<li/>').text(msg).appendTo('.ts-message ul');
    }
});