var totalRecord, currentPage, pageNow;
$(function () {
    //去首页
    to_page(1, 8);
});

//选择每页显示多少条数据
$("#action li a").click(function () {
    var singlePageDisplay = $(this).html();
    $(" #singlePageDisplay").text(singlePageDisplay);
    to_page(pageNow, singlePageDisplay);
});

function to_page(pn, singlePageDisplay) {
    $.ajax({
        // url: "/Commodity/getAllCommodity",
        url: "/Commodity/getCommodityByPage",
        data: "pn=" + pn + "&singlePageDisplay=" + singlePageDisplay,
        type: "GET",
        success: function (result) {
            console.log(result);
            //1、解析并显示商品数量数据
            build_emps_table(result);
            //2、解析并显示分页信息
            build_page_info(result);
            //3、解析显示分页条数据s
            build_page_nav(result);
        }
    });
}

//1、解析并显示商品数量数据
function build_emps_table(result) {
    //清空table表格 emps
    $("#emps_table tbody").empty();
    var com = result.data.pageInfo.list;
    $.each(com, function (index, item) {
        var idTd = $("<td></td>").append(item.id).attr("style", "text-align: center");
        var nameTd = $("<td></td>").append(item.name).attr("style", "text-align: center");
        var typeTd = $("<td></td>").append(item.type).attr("style", "text-align: center");
        var sellingPriceTd = $("<td></td>").append(item.sellingPrice + "￥").attr("style", "text-align: center");
        var purchasingPriceTd = $("<td></td>").append(item.purchasingPrice + "￥").attr("style", "text-align: center");
        var IndividualProfit = $("<td></td>").append(item.individualProfit + "￥").attr("style", "text-align: center");
        var salesTd = $("<td></td>").append(item.sales).attr("style", "text-align: center");
        var grossProfit = $("<td></td>").append(item.grossProfit).attr("style", "text-align: center");
        var realityGrossProfit = $("<td></td>").append(item.realityGrossProfit).attr("style", "text-align: center");
        var firstClassification = "";
        var secondClassification = "";
        var thirdClassification = "";
        if (item.firstClassification == null) {
            firstClassification = $("<td></td>").append("无").attr("style", "text-align: center");
        } else {
            firstClassification = $("<td></td>").append(item.firstClassificationName).attr("style", "text-align: center").attr("value", item.firstClassification);
        }
        if (item.secondClassification == null) {
            secondClassification = $("<td></td>").append("无").attr("style", "text-align: center");
        } else {
            secondClassification = $("<td></td>").append(item.secondClassificationName).attr("style", "text-align: center").attr("value", item.secondClassification);
        }
        if (item.thirdClassification == null) {
            thirdClassification = $("<td></td>").append("无").attr("style", "text-align: center");
        } else {
            thirdClassification = $("<td></td>").append(item.thirdClassificationName).attr("style", "text-align: center").attr("value", item.thirdClassification);
        }

        var createAt = $("<td></td>").append(item.createAt).attr("style", "text-align: center");

        /**
         <button class="">
         <span class="" aria-hidden="true"></span>
         编辑
         </button>
         */
        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").attr("data-toggle", "modal").attr("data-target", "#updateCommodity")
            .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
        //为编辑按钮添加一个自定义的属性，来表示当前员工id
        editBtn.attr("edit-id", item.id);


        var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
        //为删除按钮添加一个自定义的属性来表示当前删除的员工id
        delBtn.attr("del-id", item.id);
        var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).attr("style", "text-align: center");
        //var delBtn =
        //append方法执行完成以后还是返回原来的元素
        $("<tr></tr>")
            .append(idTd)
            .append(nameTd)
            .append(typeTd)
            .append(purchasingPriceTd)
            .append(sellingPriceTd)
            .append(IndividualProfit)
            .append(salesTd)
            .append(grossProfit)
            .append(realityGrossProfit)
            .append(firstClassification)
            .append(secondClassification)
            .append(thirdClassification)
            .append(createAt)
            .append(btnTd)
            .appendTo("#emps_table tbody");
    });

}


//解析显示分页信息
function build_page_info(result) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前" + result.data.pageInfo.pageNum + "页,总" +
        result.data.pageInfo.pages + "页,总" +
        result.data.pageInfo.total + "条记录");
    totalRecord = result.data.pageInfo.total;
    currentPage = result.data.pageInfo.pages;
    pageNow = result.data.pageInfo.pageNum;
}


//解析显示分页条，点击分页要能去下一页....
function build_page_nav(result) {
    var singlePageDisplay = $(" #singlePageDisplay").html();
    //page_nav_area
    $("#page_nav_area").empty();
    var ul = $("<ul></ul>");
//.addClass("pagination")
    //构建元素
    var firstPageLi = $("<a></a>").append("首页");
    var prePageLi = $("<a></a>").append("&laquo;");
    if (result.data.pageInfo.hasPreviousPage == false) {
        firstPageLi.addClass("forbidden");
        prePageLi.addClass("forbidden");
    } else {
        //为元素添加点击翻页的事件
        firstPageLi.attr("href", "#").addClass("limit").click(function () {
            to_page(1, singlePageDisplay);
        });
        prePageLi.addClass("limit").click(function () {
            to_page(result.data.pageInfo.pageNum - 1, singlePageDisplay);
        });
    }


    var nextPageLi = $("<a></a>").append("&raquo;");
    var lastPageLi = $("<a></a>").append("末页");
    if (result.data.pageInfo.hasNextPage == false) {
        nextPageLi.addClass("forbidden");
        lastPageLi.addClass("forbidden");
    } else {
        nextPageLi.addClass("limit").click(function () {
            to_page(result.data.pageInfo.pageNum + 1, singlePageDisplay);
        });
        lastPageLi.attr("href", "#").addClass("limit").click(function () {
            to_page(result.data.pageInfo.pages, singlePageDisplay);
        });
    }


    //添加首页和前一页 的提示
    ul.append(firstPageLi).append(prePageLi);
    //1,2，3遍历给ul中添加页码提示
    $.each(result.data.pageInfo.navigatepageNums, function (index, item) {

        var numLi = $("<a></a>").append(item);
        if (result.data.pageInfo.pageNum == item) {
            numLi.addClass("forbiddenPage").attr("style", "color: white");
        } else {
            numLi.addClass("limit");
        }
        numLi.click(function () {
            to_page(item, singlePageDisplay);
        });
        ul.append(numLi);
    });
    //添加下一页和末页 的提示
    ul.append(nextPageLi).append(lastPageLi);

    //把ul加入到nav
    var navEle = $("<div></div>").append(ul);
    navEle.appendTo("#page_nav_area");
}


function getEmp(id) {
    $.ajax({
        url: "Commodity/getMessageById/" + id,
        type: "GET",
        success: function (result) {
            console.log(result);
            console.log(id);
            //,,,，
            var data = result.data;
            $("#cmdName_update_input").val(data.name);
            $("#cmdNum_update_input").val(data.type);
            $("#cmdPurchasingPrice_update_input").val(data.purchasingPrice);
            $("#cmdSellingPrice_update_input").val(data.sellingPrice);
            $("#cmdSales_update_input").val(data.sales);
        }
    });
}


//单个删除
$(document).on("click", ".delete_btn", function () {
    var singlePageDisplay = $(" #singlePageDisplay").html();

    //1、弹出是否确认删除对话框
    var empName = $(this).parents("tr").find("td:eq(2)").text();
    var id = $(this).attr("del-id");
    //alert($(this).parents("tr").find("td:eq(1)").text());
    if (confirm("确认删除【" + empName + "】吗？")) {
        //确认，发送ajax请求删除即可
        $.ajax({
            url: "Commodity/deleteCommodity/" + id,
            type: "DELETE",
            success: function (result) {
                if (result.data != 0) {
                    alert("删除成功,影响行数为:" + result.data + "行");
                }
                //回到本页
                to_page(pageNow, singlePageDisplay);
            }
        });
    }
});

getFirstClass("firstClass");

//一级分类点击事件
$("#firstClass div ul ").on("click", "li a", function () {
    var firstVal = $(this).html();
    var value = $(this).attr("value");
    $(" #firstClass div div text").text(firstVal).attr("value", value);
    $(" #secondClass div div text").text("--请选择--").removeAttr("value");
    $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
    getSecondClass(value, "secondClass", "thirdClass");
    getMessageByClassId(value, 0, 0);
});
$("#updateFirstClass div ul ").on("click", "li a", function () {
    var firstVal = $(this).html();
    var value = $(this).attr("value");
    $(" #updateFirstClass div div text").text(firstVal).attr("value", value);
    $(" #updateSecondClass div div text").text("--请选择--").removeAttr("value");
    $(" #updateThirdClass div div text").text("--请选择--").removeAttr("value");
    getSecondClass(value, "updateSecondClass", "updateThirdClass");
    getMessageByClassId(value, 0, 0);
});


//二级分类点击事件
$("#secondClass div ul ").on("click", "li a", function () {
    var secondVal = $(this).html();
    var value = $(this).attr("value");
    $(" #secondClass div div text").text(secondVal).attr("value", value);
    $(" #thirdClass div div text").text("--请选择--").removeAttr("value");
    getThirdClass(value, "thirdClass");
    getMessageByClassId(0, value, 0);
});
$("#updateSecondClass div ul ").on("click", "li a", function () {
    var secondVal = $(this).html();
    var value = $(this).attr("value");
    $(" #updateSecondClass div div text").text(secondVal).attr("value", value);
    $(" #updateThirdClass div div text").text("--请选择--").removeAttr("value");
    getThirdClass(value, "updateThirdClass");
    getMessageByClassId(0, value, 0);
});
//三级分类点击事件
$("#thirdClass div ul ").on("click", "li a", function () {
    var thirdVal = $(this).html();
    var value = $(this).attr("value");
    $(" #thirdClass div div text").text(thirdVal).attr("value", value);
    getMessageByClassId(0, 0, value);
});
$("#updateThirdClass div ul ").on("click", "li a", function () {
    var thirdVal = $(this).html();
    var value = $(this).attr("value");
    $(" #updateThirdClass div div text").text(thirdVal).attr("value", value);
    getMessageByClassId(0, 0, value);
});

//获取一级分类的所有数据
function getFirstClass(firstClass) {
    $.ajax({
        url: "/ClassController/getAllFirstClassification",
        type: "GET",
        success: function (result) {
            if (result.code == 200) {
                var data = result.data;

                switch (firstClass) {
                    case "firstClass":
                        $("#firstClass div ul").empty();
                        $("#secondClass div ul").empty();
                        $("#thirdClass div ul").empty();
                        $("<li></li>").append($("<a></a>").html("请选择一级分类")).appendTo($("#secondClass div ul"));
                        $("<li></li>").append($("<a></a>").html("请选择二级分类")).appendTo($("#thirdClass div ul"));
                        for (var i = 0; i < data.length; i++) {
                            $("<li></li>").append(
                                $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num", i)
                            ).appendTo($("#firstClass div ul"));

                        }
                        break;
                    case "updateFirstClass":
                        $("#updateFirstClass div ul").empty();
                        $("#updateSecondClass div ul").empty();
                        $("#updateThirdClass div ul").empty();
                        $("<li></li>").append($("<a></a>").html("空，请添加二级分类或选择一级分类")).appendTo($("#updateSecondClass div ul"));
                        $("<li></li>").append($("<a></a>").html("空，请添加三级分类或选择二级分类")).appendTo($("#updateThirdClass div ul"));
                        for (var i = 0; i < data.length; i++) {
                            $("<li></li>").append(
                                $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num", i)
                            ).appendTo($("#updateFirstClass div ul"));

                        }
                        break;
                }

            } else {
                alert("获取一级数据失败")
            }
        }
    })
}

//获取对应一级分类的二级分类的所有数据
function getSecondClass(firstVal, secondClass) {
    $.ajax({
        url: "/ClassController/getAllSecondClassification/" + firstVal,
        type: "GET",
        success: function (result) {
            if (result.code == 200) {
                var data = result.data;
                switch (secondClass) {
                    case"secondClass":
                        $("#secondClass div ul").empty();
                        $("#thirdClass div ul").empty();
                        if (data.length == 0) {
                            $("<li></li>").append($("<a></a>").html("请选择一级分类")).appendTo($("#thirdClass div ul"));
                        }
                        for (var i = 0; i < data.length; i++) {
                            $("<li></li>").append(
                                $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num", i)
                            ).appendTo($("#secondClass div ul"));
                        }
                        ;
                        break;
                    case "updateSecondClass":
                        $("#updateSecondClass div ul").empty();
                        $("#updateThirdClass div ul").empty();
                        if (data.length == 0) {
                            $("<li></li>").append($("<a></a>").html("空，请添加三级分类或选择二级分类")).appendTo($("#updateThirdClass div ul"));
                        }
                        for (var i = 0; i < data.length; i++) {
                            $("<li></li>").append(
                                $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num", i)
                            ).appendTo($("#updateSecondClass div ul"));
                        }
                        ;
                        break;
                }

            } else {
                alert("二级分类获取数据失败")
            }
        }
    })


}

//获取对应二级分类的所有三级分类的数据
function getThirdClass(secondVal, thirdClass) {
    $.ajax({
        url: "/ClassController/getAllThirdClassification/" + secondVal,
        type: "GET",
        success: function (result) {
            if (result.code == 200) {
                var data = result.data;

                switch (thirdClass) {
                    case "thirdClass":
                        $("#thirdClass div ul").empty();
                        for (var i = 0; i < data.length; i++) {
                            $("<li></li>").append(
                                $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num", i)
                            ).appendTo($("#thirdClass div ul"));
                        }
                        ;
                        break;
                    case "updateThirdClass":
                        $("#updateThirdClass div ul").empty();
                        for (var i = 0; i < data.length; i++) {
                            $("<li></li>").append(
                                $("<a></a>").append(data[i].name).attr("value", data[i].id).attr("href", "#").attr("num", i)
                            ).appendTo($("#updateThirdClass div ul"));
                        }
                        ;
                        break;
                }


            } else {
                alert("三级分类获取数据失败");
            }
        }
    })

}


/**
 * 通过类别ID查询商品详情
 * @param firstClassId
 * @param secondClassId
 * @param thirdClassId
 */
function getMessageByClassId(firstClassId, secondClassId, thirdClassId) {
    var singlePageDisplay = $(" #singlePageDisplay").html();
    $.ajax({
        url: "Commodity/getMessageByClassId",
        data: "singlePageDisplay=" + singlePageDisplay + "&firstClassId=" + firstClassId + "&secondClassId=" + secondClassId + "&thirdClassId=" + thirdClassId,
        type: "GET",
        success: function (result) {
            console.log(result);
            //1、解析并显示商品数量数据
            build_emps_table(result);
            //2、解析并显示分页信息
            build_page_info(result);
            //3、解析显示分页条数据s
            build_page_nav(result);
        }
    })


}


$("#emps_table ").on('click', ".btn-primary", function () {

    var id = $(this).attr("edit-id");
    $.ajax({
        url: "Commodity/getMessageById/" + id,
        type: "GET",
        success: function (result) {
            getFirstClass("updateFirstClass");
            var data = result.data;
            $("#cmdName_update_input").empty();
            $("#cmdName_update_input").val(data.name);

            $("#cmdNum_update_input").empty();
            $("#cmdNum_update_input").val(data.type);

            $("#cmdPurchasingPrice_update_input").empty();
            $("#cmdPurchasingPrice_update_input").val(data.purchasingPrice);

            $("#cmdSellingPrice_update_input").empty();
            $("#cmdSellingPrice_update_input").val(data.sellingPrice);

            $("#updateFirstClass div div text").html("--请选择--");
            $("#updateFirstClass div div text").html(data.firstClassificationName);

            $("#updateSecondClass div div text").html("--请选择--");
            $("#updateSecondClass div div text").html(data.secondClassificationName);

            $("#updateThirdClass div div text").html("--请选择--");
            $("#updateThirdClass div div text").html(data.thirdClassificationName);
            console.log(result);
        }
    })


})





