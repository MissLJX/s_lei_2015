<h3>策略模式</h3>
<h4>定义:</h4>
&nbsp;&nbsp;&nbsp;&nbsp;定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。
<h4>例子：</h4>
&nbsp;&nbsp;&nbsp;&nbsp;1.使用策略模式实现简单的加减计算器<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2.使用策略枚举实现简单的加减计算器<br/>
<h4>总结:</h4>
&nbsp;&nbsp;&nbsp;&nbsp;优点：算法自由切换；避免多重判断；并且拓展性很好，可以任意添加策略。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;缺点：每一个算法都是一个策略类，随着算法的增多，策略类就会增多，不易维护；并且所有策略必须全部暴露给客户，客户才能知道使用那些算法。<br/>
