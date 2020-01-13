$(function () {
    $('#tab1').mouseover(function () {
        $('.down-menu_one').attr('style','display:block');
    });
    $('#tab1').mouseout(function () {
        $('.down-menu_one').attr('style','display:none');
    });
    $('#tab2').mouseover(function () {
        $('.down-menu_two').attr('style','display:block');
    });
    $('#tab2').mouseout(function () {
        $('.down-menu_two').attr('style','display:none');
    });
    $('#tab3').mouseover(function () {
        $('.down-menu_three').attr('style','display:block');
    });
    $('#tab3').mouseout(function () {
        $('.down-menu_three').attr('style','display:none');
    });
});