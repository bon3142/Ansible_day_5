Vagrant.configure("2") do |config|

  config.vm.define "master3" do |master_node|
    master_node.vm.box = "sbeliakou/centos"
    master_node.vm.hostname = "master3"
    master_node.vm.network "private_network", ip: "192.168.56.2"
    master_node.vm.provider "virtualbox" do |vb|
      vb.name = "master3"
      vb.memory = "2048"
    master_node.vm.synced_folder "data", "/opt/jenkins", mount_options: ["uid=5500", "gid=5500"]


   end
end
   config.vm.define "Slave1" do |vm2|
    vm2.vm.network :private_network, ip: "192.168.56.3"
    vm2.vm.box = "sbeliakou/centos"
    vm2.vm.hostname = "Slave1"
    vm2.ssh.insert_key = false
    vm2.vm.provider "virtualbox" do |ss|
    ss.name = "Slave1"
    ss.memory = "1024"
  end
end 
 config.vm.define "Slave2" do |vm3|
   vm3.vm.network :private_network, ip: "192.168.56.4"
   vm3.vm.box = "sbeliakou/centos"
   vm3.vm.hostname = "Slave2"
   vm3.ssh.insert_key = false
   vm3.vm.provider "virtualbox" do |cc|
   cc.name = "Slave2"
   cc.memory = "1024"
 end
end
 config.vm.define "tomcat" do |vm4|
   vm4.vm.network :private_network, ip: "192.168.56.5"
   vm4.vm.box = "sbeliakou/centos"
   vm4.vm.hostname = "tomcat"
   vm4.ssh.insert_key = false
   vm4.vm.provider "virtualbox" do |nn|
   nn.name = "tomcat"
   nn.memory = "1024"
 end
end


 config.vm.provision "ansible" do |ansible|
    ansible.playbook = "playbook.yml"
    ansible.inventory_path = "inventory1"
  end

end
