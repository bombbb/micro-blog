
echo +++++++++ 正在将micro-blog项目上传到github.....................
echo +++++++++复制前端文件...............
rm -rf FrontEnd
echo +++++++++创建目录FronEnd...............
mkdir FrontEnd
echo +++++++++复制目录...............
cp -r  /nginx/microblog  /home/lgj/aProject/aRealPrj/microblog/FrontEnd  
echo +++++++++复制nginx.conf
cp /etc/nginx/nginx.conf  /home/lgj/aProject/aRealPrj/microblog/FrontEnd/nginx.conf

echo  ++++++++git add  .
git add .
echo  ++++++++git add finish 
echo  ++++++++git commit -m 
git commit -m "$1"
echo  ++++++++上传备注： $1

git push origin master
echo ++++++++上传成功！





