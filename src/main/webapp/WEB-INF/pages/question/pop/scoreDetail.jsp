<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <div class="pageFormContent" layoutH="58">

        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="main" style="width: 100%;height:400px;"></div>
        <div id="tableScore">
            <table class="table" width="100%" layoutH="138">
                <thead>
                <tr>
                    <th width="40">考试日期</th>
                    <th width="60">分数</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${data}" var="da">
                    <tr target="sid_user" rel="1">
                        <td>${da.examTime}</td>
                        <td>${da.obtainScore}分</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            var datax = [];
            var dataY = [];
            <c:forEach items="${data}" var="da">
            datax[datax.length] = "${da.examTime}";
            dataY[dataY.length] = ${da.obtainScore};
            </c:forEach>
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '${personName}的考试成绩'
                },
                color: ['#3398DB'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: datax,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        type: 'bar',
                        barWidth: '30px',
                        data: dataY
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        </script>

    </div>
    <div class="formBar">
        <ul>
            <li>
                <div class="button">
                    <div class="buttonContent">
                        <button type="button" class="close">取消</button>
                    </div>
                </div>
            </li>
        </ul>
    </div>

</div>

