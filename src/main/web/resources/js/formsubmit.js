$(document).ready(function() {

    $(document).on("click",".js-submit",function(e) {
        e.preventDefault();

        var pageNumber = getPageNumber();

        $.ajax({
            type: "POST",
            url: "validate/form",
            data: $(".js-form").serialize(),
            success: function (response) {
                if (response.errors != null){
                    $.each(response.errors, function (fieldName, fieldError) {
                        var selector = ".js-err-" + fieldName;
                        $(selector).removeClass("hidden");
                        $(selector + " input").val(fieldError);
                        $("tbody").html("");
                    });
                } else {
                    $(".js-form span").addClass("hidden");
                    getPlants(pageNumber);
                }
            }
        });

        function getPlants(pageNumber) {
            $.ajax({
                type: "POST",
                url: "submit/form?pn=" + pageNumber,
                data: $(".js-form").serialize(),
                success: function (response) {
                    $(".js-table-container").html(response);
                    renderPagination();
                }
            });
        }

        function getPageNumber() {
            var pageNumberFieldVal = $("input[name='pageNumber']").val();
            return  pageNumberFieldVal ? pageNumberFieldVal: 0;
        }

        function renderPagination() {
            var currpage = parseInt($("input[name='pageNumber']").val()) + 1;
            var totalpage = parseInt($("input[name='totalPageCount']").val());
            if (totalpage){
                $(".js-pagination").twbsPagination({
                    totalPages: totalpage,
                    visiblePages: 6,
                    startPage: currpage,
                    initiateStartPageClick: false,
                    first: "&lt;&lt;",
                    prev: "&lt;",
                    next: "&gt;",
                    last: "&gt;&gt;",
                    paginationClass: "pagination",
                    onPageClick: function (event, page) {
                        $("input[name='pageNumber']").val(page-1);
                        $(".js-submit").trigger("click");
                    }
                });
            }
        }
    });

    $(document).on("input change",".js-form input",function(e) {
        e.preventDefault();
        $("input[name='pageNumber']").val(0);
    });
});