#version 300 es
precision mediump float;
uniform mat4 uMVPMatrix; //总变换矩阵
in vec4 aPosition;  //顶点位置
in vec2 aTexCoor;    //顶点纹理坐标
out vec2 vTextureCoord;  //用于传递给片元着色器的out变量
out vec4 vPosition;//用于传递给片元着色器的顶点位置属性
void main()
{
   gl_Position = uMVPMatrix * vec4(aPosition.x,aPosition.y,0.0,1); //根据总变换矩阵计算此次绘制此顶点位置
   vTextureCoord = aTexCoor;//将接收的纹理坐标传递给片元着色器
   vPosition=vec4(aPosition.x,aPosition.y,0.0,aPosition.w);//计算顶点位置属性，并将其传递给片元着色器

}