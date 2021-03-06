[#-------------- INCLUDE AND ASSIGN PART --------------]
[#include "/mtk/templates/includes/init.ftl"]

[#-- CSS default --]
[#if !divClass?has_content]
    [#assign divClass = "video-container"]
[/#if]

[#-- video css classes --]
[#assign videoHtml = ""]
[#if content.type?exists]
    [#include "/travel-demo/templates/macros/video.ftl"]
    [#assign videoHtml][@video content/][/#assign]
[/#if]


[#-------------- RENDERING PART --------------]
[#-- Rendering: video item --]
<div ${divID!} class="${divClass} clearfix">
     ${videoHtml}
</div><!-- end ${divClass} -->
