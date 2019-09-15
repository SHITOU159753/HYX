//$(" #firstClass div div text").attr("value")获取的是分类id
getFirstClass();

//一级分类点击事件
$("#firstClass div ul ").on("click", "li a", function () {
    var firstVal = $(this).html();
    var value = $(this).attr("value");
    $(" #firstClass div div text").text(firstVal).attr("value",value);
    $(" #secondClass div div text").text("--请选择--").removeAttr("value");
    $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
    getSecondClass(value);
});
//二级分类点击事件
$("#secondClass div ul ").on("click", "li a", function () {
    var secondVal = $(this).html();
    var value = $(this).attr("value");
    $(" #secondClass div div text").text(secondVal).attr("value",value);
    $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
    getThirdClass(value);
});
//三级分类点击事件
$("#thirdClass div ul ").on("click", "li a", function () {
    var thirdVal = $(this).html();
    var value = $(this).attr("value");
    $(" #thirdClass div div text").text(thirdVal).attr("value",value);
});

//获取一级分类的所有数据
function getFirstClass() {
    $.ajax({
        url: "/ClassController/getAllFirstClassification",
        type: "GET",
        success: function (result) {
            if(result.code == 200){
                var data = result.data;

                $("#firstClass div ul").empty();
                $("#secondClass div ul").empty();
                $("#thirdClass div ul").empty();
                for (var i = 0; i < data.length; i++) {
                    $("<li></li>").append(
                        $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num",i)
                    ).appendTo($("#firstClass div ul"));
                };
            }else{
                alert("获取一级数据失败")
            }

        }

    })
}
//获取对应一级分类的二级分类的所有数据
function getSecondClass(firstVal) {
    $.ajax({
        url: "/ClassController/getAllSecondClassification/" + firstVal,
        type: "GET",
        success: function (result) {
            if(result.code == 200){
                var data = result.data;

                $("#secondClass div ul").empty();
                $("#thirdClass div ul").empty();
                for (var i = 0; i < data.length; i++) {
                    $("<li></li>").append(
                        $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num",i)
                    ).appendTo($("#secondClass div ul"));
                };
            }else{
                alert("二级分类获取数据失败")
            }

        }
    })
}
//获取对应二级分类的所有三级分类的数据
function getThirdClass(secondVal) {
    $.ajax({
        url: "/ClassController/getAllThirdClassification/" + secondVal,
        type: "GET",
        success: function (result) {
            if(result.code == 200){
                var data = result.data;
                $("#thirdClass div ul").empty();
                for (var i = 0; i < data.length; i++) {
                    $("<li></li>").append(
                        $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num",i)
                    ).appendTo($("#thirdClass div ul"));
                };
            }else{
                alert("三级分类获取数据失败");
            }

        }
    })
}


//一级分类修改函数
$("#firstClass div .btn-update").click(function () {
    //原数据
    var firstValue = $(" #firstClass div div text").attr("value");
    if (firstValue == undefined || firstValue == '') {
        alert("请选择需要修改的数据");
        return;
    }
    //修改后的数据
    var firstInputVal = $("#firstClass div input").val();
    if (firstInputVal == undefined || firstInputVal == '') {
        alert("请填写修改后的数据");
        return;
    }
    var num = $(" #firstClass div div text").attr("num");
    if (num == undefined || num == '') {
        alert("无法获取当前数据的下标");
        return;
    }
    //修改通用方法
    updateUtilFunction(firstValue, firstInputVal, "firstClass",num);
});
//一级分类添加函数
$("#firstClass div .btn-add").click(function () {
    //需要添加的数据
    var firstInputVal = $("#firstClass div input").val();
    if (firstInputVal == undefined || firstInputVal == '') {
        //可以加颜色边框
        alert("请输入需要添加的内容");
        return;
    }
    //添加通用方法
    addUtilFunction(0,firstInputVal, "firstClass");
});
//一级分类删除
$("#firstClass div .btn-delete").click(function () {
    //删除数据
    var firstValue = $(" #firstClass div div text").attr("value");
    if (firstValue == undefined || firstValue == '') {
        alert("请选择需要删除的数据");
        return;
    }
    //删除通用方法
    deleteUtilFunction(firstValue, "firstClass");
});


//二级分类修改函数
$("#secondClass div .btn-update").click(function () {
    //原数据
    var secondValue = $(" #secondClass div div text").attr("value");
    if (secondValue == undefined || secondValue == '') {
        alert("请选择需要修改的数据");
        return;
    }
    //修改后的数据
    var secondInputVal = $("#secondClass div input").val();
    if (secondInputVal == undefined || secondInputVal == '') {
        alert("请填写修改后的数据");
        return;
    }
    var num = $(" #secondClass div div text").attr("num");
    if (num == undefined || num == '') {
        alert("无法获取当前数据的下标");
        return;
    }
    //修改通用方法
    updateUtilFunction(secondValue, secondInputVal, "secondClass",num);
});
//二级分类添加函数
$("#secondClass div .btn-add").click(function () {
    //需要添加的数据
    var secondInputVal = $("#secondClass div input").val();
    var firstValue = $(" #firstClass div div text").attr("value");
    if (secondInputVal == undefined || secondInputVal == '') {
        alert("请输入需要添加的内容");
        return;
    }
    if(firstValue == undefined || firstValue == ''){
        alert("请选择一级分类")
        return;
    }
    //添加通用方法
    addUtilFunction(firstValue,secondInputVal, "secondClass");
});
//二级分类删除
$("#secondClass div .btn-delete").click(function () {
    //删除数据
    var secondValue = $(" #secondClass div div text").attr("value");
    if (secondValue == undefined || secondValue == '') {
        alert("请选择需要删除的数据");
        return;
    }
    //删除通用方法
    deleteUtilFunction(secondValue, "secondClass");
});


//三级分类修改函数
$("#thirdClass div .btn-update").click(function () {
    //原数据
    var thirdValue = $(" #thirdClass div div text").attr("value");
    if (thirdValue == undefined || thirdValue == '') {
        alert("请选择需要修改的数据");
        return;
    }
    //修改后的数据
    var thirdInputVal = $("#thirdClass div input").val();
    if (thirdInputVal == undefined || thirdInputVal == '') {
        alert("请填写修改后的数据");
        return;
    }
    var num = $(" #thirdClass div div text").attr("num");
    if (num == undefined || num == '') {
        alert("无法获取当前数据的下标");
        return;
    }
    //修改通用方法
    updateUtilFunction(thirdValue, thirdInputVal, "thirdClass",num);
});
//三级分类添加函数
$("#thirdClass div .btn-add").click(function () {
    //需要添加的数据
    var thirdInputVal = $("#thirdClass div input").val();
    var secondValue = $(" #secondClass div div text").attr("value");
    if (thirdInputVal == undefined || thirdInputVal == '') {
        alert("请输入需要添加的内容");
        return;
    }
    if(secondValue == undefined || secondValue == ''){
        alert("请选择二级级分类")
        return;
    }
    //添加通用方法
    addUtilFunction(secondValue,thirdInputVal, "thirdClass");
});
//三级分类删除
$("#thirdClass div .btn-delete").click(function () {
    //删除数据
    var thirdValue = $(" #thirdClass div div text").attr("value");
    if (thirdValue == undefined || thirdValue == '') {
        alert("请选择删除的数据");
        return;
    }
    //删除通用方法
    deleteUtilFunction(thirdValue, "thirdClass");
});


//通用修改方法
function updateUtilFunction(value, inputVal, className,num) {
    var data = "originalId=" + value + "&updateData=" + inputVal + "&className=" + className;
    $.ajax({
        url:"/ClassController/updateClass",
        data:data,
        type:"POST",
        success:function (result) {
            var data = result.data;
            if(data == 1){
                switch (className) {
                    case "firstClass":
                        $("#firstClass div input").val("");
                        $(" #firstClass div div text").text(inputVal);
                        $("#firstClass div ul li a").eq(num).html(inputVal);
                        break;
                    case "secondClass":
                        $("#secondClass div input").val("");
                        $("#secondClass div div text").text(inputVal);
                        $("#secondClass div ul li a").eq(num).html(inputVal);
                        break;
                    case "thirdClass":
                        $("#thirdClass div input").val("");
                        $("#thirdClass div div text").text(inputVal);
                        $("#thirdClass div ul li a").eq(num).html(inputVal);
                        break;
                }
            }

        }
    })
}
//通用添加方法
function addUtilFunction(superiorId,inputVal, className) {
    var data = "superiorId="+superiorId+"&inputVal=" + inputVal + "&className=" + className;
    $.ajax({
        url:"/ClassController/addClass",
        data:data,
        type:"POST",
        success:function (result) {
            if(result.data == 1){
                switch (className) {
                    case "firstClass":
                        $("#firstClass div input").val("");
                        $(" #firstClass div div text").text("--请选择--").removeAttr("value");
                        $(" #secondClass div div text").text("--请选择--").removeAttr("value");
                        $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
                        getFirstClass();
                        break;
                    case "secondClass":
                        $("#secondClass div input").val("");
                        $(" #secondClass div div text").text("--请选择--").removeAttr("value");
                        $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
                        getSecondClass(superiorId);
                        break;
                    case "thirdClass":
                        $("#thirdClass div input").val("");
                        $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
                        getThirdClass(superiorId);
                        break;
                }
            }
        }
    })

}

//通用删除方法
function deleteUtilFunction(id, className) {
    var data = "id=" + id + "&className=" + className;
    $.ajax({
        url:"/ClassController/removeClass",
        data:data,
        type:"POST",
        success:function (result) {
            if(result.code == 200){
                if(result.data == 1){
                    switch (className) {
                        case "firstClass":
                            $(" #firstClass div div text").text("--请选择--").removeAttr("value");
                            getFirstClass();
                            break;
                        case "secondClass":
                            var superiorId = $(" #firstClass div div text").attr("value");
                            $(" #secondClass div div text").text("--请选择--").removeAttr("value");
                            getSecondClass(superiorId);
                            break;
                        case "thirdClass":
                            var superiorId = $(" #secondClass div div text").attr("value");
                            $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
                            getThirdClass(superiorId);
                            break;
                    }
                }
            }else{
                alert(result.msg);
                return
            }
        }
    })

}