$(document).ready(function() {

    $(document).on("click",".js-submit",function(e) {
        e.preventDefault();

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
                    getPlants();
                }
            }
        });

        function getPlants() {
            $.ajax({
                type: "POST",
                url: "submit/form",
                data: $(".js-form").serialize(),
                success: function (response) {
                    $("tbody").html(response);
                }
            });
        }
    });
});