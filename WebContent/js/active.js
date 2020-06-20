(function ($) {
    'use strict';

    if ($.fn.owlCarousel) {
        // Hero Slider Active Code
        $(".features-slides").owlCarousel({
            items: 5,
            loop: true,
            autoplay: false,
            smartSpeed: 2000,
            margin: 50,
            nav: false,
            responsive: {
                0: {
                    items: 1
                },
                576: {
                    items: 2
                },
                992: {
                    items: 3
                },
                1200: {
                    items: 5
                }
            }
        })
    }

    // Search Active Code
    $('#search-btn, #closeBtn').on('click', function () {
    	$("#search").focus();
        $('body').toggleClass('search-form-on');
    });
    
    // matchHeight Active Code
    if ($.fn.matchHeight) {
        $('.equal-height').matchHeight();
    }
    
    // ScrollUp Active Code
    if ($.fn.scrollUp) {
        $.scrollUp({
            scrollSpeed: 1500,
            scrollText: '<i class="pe-7s-angle-up" aria-hidden="true"></i>'
        });
    }

    // onePageNav Active Code
    if ($.fn.onePageNav) {
        $('#listingNav').onePageNav({
            currentClass: 'active',
            scrollSpeed: 2000,
            easing: 'easeOutQuad'
        });
    }

    // PreventDefault a Click
    $("a[href='#']").on('click', function ($) {
        $.preventDefault();
    });

    // wow Active Code
    if ($.fn.init) {
        new WOW().init();
    }

    var $window = $(window);

    // Sticky Active JS
    $window.on('scroll', function () {
        if ($window.scrollTop() > 0) {
            $('body').addClass('sticky');
        } else {
            $('body').removeClass('sticky');
        }
    });

    // Preloader Active Code
    $window.on('load', function () {
        $('#preloader').fadeOut('slow', function () {
            $(this).remove();
        });
    });

})(jQuery);

$("#like_notUser").on("click", function() {
	// 비회원 좋아요 버튼 클릭.
	alert("해당 기능은 로그인 한 회원만 이용 가능합니다. \n 확인을 클릭하시면  로그인창으로 이동합니다.");
	location.href="momo.do?command=login";
});

$(".like_a").on("click", function() {
	var like1 = $(".like").val();
	var clubNo = $("#clubNo3").val();

	alert("like1 : " + like1 + " clubNo : " + clubNo);
	
	$.ajax({
		url : "momo.do?command=likeClick&likeYN="+ like1 + "&clubNo=" + clubNo,
		type : "get",
		success: function(data) {
			if(data == 1){
				alert("Y");
				location.reload();
			} else {
				alert("N");
				location.reload();
			}
		},
		error : function(request, status, error){
			alert("에러 발생!");
		}

	});
});

