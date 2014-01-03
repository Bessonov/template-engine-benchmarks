## [Httl - 1.0.11] (http://httl.github.io/en/)
Last release : March, the 16 2013

License : [Apache license] (https://github.com/httl/httl/blob/master/LICENSE)

[Tutorial] (http://httl.github.io/en/example.html)

## Code
[Java: src/teb/Httl.java] (src/teb/Httl.java)

[Template: templates/stocks.httl.html] (templates/stocks.httl.html)

## Syntax 
```` html
   <tbody>
	<!--#foreach(item in items)-->
	<tr class="${foreach.index % 2 == 1 ? "even" : "odd"}">
		<td style="text-align: center">${foreach.index + 1}</td>

		<td>
			<a href="/stocks/${item.symbol}">${item.symbol}</a>
		</td>

		<td>
			<a href="${item.url}">${item.name}</a>
		</td>

		<td>
			<strong>${item.price}</strong>
		</td>

		<!--#if (item.change < 0.0) -->
		<td class="minus">${item.change}</td>
		<td class="minus">${item.ratio}</td>
		<!--#else-->
		<td>${item.change}</td>
		<td>${item.ratio}</td>
		<!--#end-->

		</tr>
	<!--#end-->
   </tbody>
````
