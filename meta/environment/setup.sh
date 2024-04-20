# 初始化环境,linux版本

# 一旦中间有个命令失败就停止往下执行，windows下的该命令不生效。
#set-e

# 清空docker
#echo 'start to clear the contents of the docker'
#docker kill $(docker ps -a -q)
#docker rm $(docker ps -a -q)
#docker rmi -f $(docker images -q)
#echo 'The content in the docker has been cleared successfully'

# 安装pgSQL镜像
if test "$(docker images -q postgres:15.2)" != "";
then
		echo "postgreSQL:15.2 Mirror exists"
else
    echo "postgreSQL:15.2 The image does not exist. Starting to obtain the image"
    docker pull postgres:15.2
    echo "postgreSQL:15.2 Image acquisition completed"
fi

# 初始化pgSQL容器
containerNameOfPgSQL="pgsql-redfish"

if test "$(docker ps -a -q -f name=${containerNameOfPgSQL})" != "";
then
		echo "${containerNameOfPgSQL} container exists, start restarting"
		docker stop ${containerNameOfPgSQL}
    docker start ${containerNameOfPgSQL}
    echo "${containerNameOfPgSQL} start completed"
else
    echo "container ${containerNameOfPgSQL} start creating"
    # windows换成以下命令,windows用shell脚本执行一下run命令会有路径上的问题，使用cmd执行。
    #docker run -itd -p 5432:5432 -v D:\DockerData\data\pgsql:/var/lib/postgresql/data --name ${containerNameOfPgSQL} -e POSTGRES_PASSWORD=123456 --restart=always bf700010ce28
#    docker run -itd -p 5432:5432 -v /mydata/postgres/pgdata:/var/lib/postgresql/data --name ${containerNameOfPgSQL} -e POSTGRES_PASSWORD=123456 bf700010ce28
    echo "container ${containerNameOfPgSQL} creation completed"

fi


# 初始化数据表
echo "start to enter the container of ${containerNameOfPgSQL}, in order to init the tables"
# 待完善

echo "Data table initialization completed,Exited container successfully"


read

