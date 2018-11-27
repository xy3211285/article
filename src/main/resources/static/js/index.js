$(function () {
    $('#submit').click(function () {
        var formData = new FormData();
        formData.append("img", $('#img')[0].files[0]);
        var url = baseDir + "/user/uploadImg";
        $.ajax({
            url: url,
            data: formData,
            type: "post",
            processData: false,
            contentType: false,
            success: function (data) {
                alert('tianjia成功！')
                $('#show_img').attr("src", baseDir + data.path)
            }
        });
    });

    $('#save_data').click(function () {
            $.post(baseDir + "/user/insertUserInfo", {
                "id":"",
                "userId":"",
                "name":"dasfsf",
                    "level":"",
                    "dept":"",
                    "offer":"",
                    "address":"",
                    "tel":"dfsaf",
                    "info":"",
                    "imageUrl":null
                }
            , function (data) {
                    if (data.result === 'success') {
                        alert('保存成功！')
                    }
                }
            )
        }
    );

    $('#get_data').click(function () {
        $.post(baseDir + "/user/getUserInfo", {ids: "001,002"}, function (data) {
            if (data.result === 'success') {
                alert(JSON.stringify(data.data));
            }
        });
    });

    $('#del_data').click(function () {
        $.post(baseDir + "/user/deleteUserInfo", {ids: "001"}, function (data) {
            alert("删除数据成功");
        })
    })
});
