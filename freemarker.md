## [Freemarker - 2.3.20] (http://freemarker.org/)

[Tutorial] (http://freemarker.org/docs/dgui_quickstart_template.html)

|                     |                                                                     | 
| ------------------- |:-------------------------------------------------------------------:| 
| Last release        | 2013-06-27                                                          |
| License             | [BSD style] (http://freemarker.org/docs/app_license.html) |
| [Gae] (https://developers.google.com/appengine/?hl=tr&csw=1) compatible             | [Yes] (http://sourceforge.net/projects/freemarker/files/freemarker/2.3.20/freemarker-gae-2.3.20.jar/download) |


## Code
[Java: src/teb/FreeMarker.java] (src/teb/FreeMarker.java)

[Template: templates/stocks.ftl.html] (templates/stocks.ftl.html)

## Syntax 
```` html
    <tbody>
	<#list items as item>
		<tr class="${["odd", "even"][item_index%2]}">
			<td style="text-align: center">${item_index + 1}</td>
			<td>
				<a href="/stocks/${item.symbol}">${item.symbol}</a>
			</td>

			<td>
				<a href="${item.url}">${item.name}</a>
			</td>

			<td>
				<strong>${item.price}</strong>
			</td>

			<#if (item.change < 0.0)>
				<td class="minus">${item.change}</td>
				<td class="minus">${item.ratio}</td>
			<#else>
				<td>${item.change}</td>
				<td>${item.ratio}</td>
			</#if>
		</tr>
	</#list>
	</tbody>
````
