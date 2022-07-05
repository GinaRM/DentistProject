$(document).ready(function(){
    $("#update_dentist_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let dentistId = $("#dentist_id").val();
            
        let formData = {
            id: $("#dentist_id").val(),
            name : $("#name").val(),
            lastName :  $("#lastName").val(),
            license: $("#license").val(),
        }
            
            $.ajax({
                url: '/dentists/' + dentistId,
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let dentist = response;
        
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> Dentist Updated </strong></div>'

                 
                    $("#tr_" + dentistId + " td.td_first_name").text(dentist.name.toUpperCase());
                    $("#tr_" + dentistId + " td.td_last_name").text(dentist.lastName.toUpperCase());
                    $("#tr_" + dentistId + " td.td_license").text(dentist.license);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Error </strong></div>';

                    $("#response").empty();                                    
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let dentistId = id_of_button.split("_")[2];
  
        $.ajax({
            url: '/dentists/' + dentistId,
            type: 'GET',
            success: function(response) {
                let dentist = response;
                $("#dentist_id").val(dentist.id);
                $("#name").val(dentist.name);
                $("#lastName").val(dentist.lastName);
                $("#license").val(dentist.license);
                $("#div_dentist_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});