#version 300 es
precision mediump float;
uniform sampler2D sTexture;//纹理内容数据
uniform float bj;//纹理矩形半径
in vec2 vTextureCoord; //接收从顶点着色器传过来的纹理坐标
in vec4 vPosition;//接收从顶点着色器传过来的片元位置属性
out vec4 fragColor;
void main()
{
   	if(vPosition.w==10.0)
   	{
   	    //该片元的生命期为10.0时，处于未激活状态，不绘制
   		fragColor=vec4(0.0,0.0,0.0,0.0);//舍弃此片元
   	}else
   	{
   	    //该片元的生命期不为10.0时，处于活跃状态，绘制
   		vec4 colorTL = texture(sTexture, vTextureCoord);//进行纹理采样
   		fragColor=colorTL;//将计算出来的片元颜色送到渲染管线
    }
}