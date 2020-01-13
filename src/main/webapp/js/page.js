$(function () {
    $('.number_main').click(function () {
        $('.iframe_page_three').load('toMain');
    });
    $('.tab1_a').click(function () {
        $('.iframe_page_three').load('user');
    });
    $('.down-menu_one_a1').click(function () {
        $('.iframe_page_three').load('toAddUser');
    });
    $('.down-menu_one_a2').click(function () {
        $('.iframe_page_three').load('toGrantRole');
    });
    $('.tab2_a').click(function () {
        $('.iframe_page_three').load('role');
    });
    $('.down-menu_two_a1').click(function () {
        $('.iframe_page_three').load('toAddRole');
    });
    $('.down-menu_two_a2').click(function () {
        $('.iframe_page_three').load('toGrantPermission');
    });
    $('.tab3_a').click(function () {
        $('.iframe_page_three').load('privilage');
    });
    $('.down-menu_three_a1').click(function () {
        $('.iframe_page_three').load('toIntroduce');
    });
    $('.down-menu_three_a2').click(function () {
        $('.iframe_page_three').load('toAddPrivilage');
    });
});