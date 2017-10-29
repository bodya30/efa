$(document).ready(function() {

    $(document).on("click",".js-submit, .js-page",function(e) {
        e.preventDefault();

        var pageNumber = getPageNumber(e);

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
                }
            });
        }

        function getPageNumber(e) {
            var pageNumber = 0;
            if ($(e.target).is(".js-submit") && $(".js-pagination").length){
                pageNumber = $(".js-page.active").attr("href");
            } else if ($(e.target).is(".js-page")){
                pageNumber = $(e.target).attr("href");
            }
            return pageNumber;
        }
    });
});