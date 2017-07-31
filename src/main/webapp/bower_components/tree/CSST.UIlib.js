
Date.prototype.toStr = function(){
	var str = this.getFullYear() + "-" + (this.getMonth()+1).format("##") + "-" + this.getDate().format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preOneHour =function(){
	var str = this.getFullYear() + "-" + (this.getMonth()+1).format("##") + "-" + this.getDate().format("##");
	str = str + " " + (this.getHours()-1).format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preOneDay =function(){
	var str = this.getFullYear() + "-" + (this.getMonth()+1).format("##") + "-" + (this.getDate()-1).format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preTwoDay =function(){
	var str = this.getFullYear() + "-" + (this.getMonth()+1).format("##") + "-" + (this.getDate()-2).format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preOneWeek = function(){
	var str = this.getFullYear() + "-" + (this.getMonth()+1).format("##") + "-" + (this.getDate()-7).format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preOneMonth = function(){
	var str = this.getFullYear() + "-" + this.getMonth().format("##") + "-" + this.getDate().format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preTwoMonth = function(){
	var str = this.getFullYear() + "-" + (this.getMonth()-1).format("##") + "-" + this.getDate().format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
Date.prototype.preOneYear = function(){
	var str = (this.getFullYear()-1) + "-" + (this.getMonth()+1).format("##") + "-" + this.getDate().format("##");
	str = str + " " + this.getHours().format("##") + ":" + this.getMinutes().format("##") + ":" + this.getSeconds().format("##");
	return str;
};
/**
 * 把字符串转换成日期
 * @returns
 */
String.prototype.toDate = function(){
	if(this.trim().length==0)
		return null;
		
	var ss = this.split(" ");
	
	var daySS =  ss[0].split("-");
	var value = new Date(0);
	value.setHours(0);
	value.setFullYear(1*daySS[0]);
	value.setMonth(1*daySS[1]-1);
	value.setDate(1*daySS[2]);
	if(ss.length>1){
		var timeSS = ss[1].split(":");
		value.setHours(1*timeSS[0]);
		value.setMinutes(1*timeSS[1]);
		value.setSeconds(1*timeSS[2]);
	}
	return value;
}

//去掉字符串首尾空格
String.prototype.trim = function () {
	var reg =  /(^\s*)|(\s*$)/g;
	return this.replace(reg, "");
};

//判断字符串是否以某个子串结尾的
String.prototype.endsWith = function(s){
	var p = this.lastIndexOf(s);
	if(p+s.length==this.length){
		return true;
	}else
		return false;
};

String.prototype.startsWith = function(s){
	var p = this.indexOf(s);
	return p==0;
};



//****************************************************************
//* 功    能：计算字符串的长度(Unicode长度为2，非Unicode长度为1)
//*****************************************************************
String.prototype.asciiLen = function(){
	var intLength=0
	for (var i=0;i<this.length;i++){
		if ((this.charCodeAt(i) < 0) || (this.charCodeAt(i) > 255))
			intLength=intLength+2;
		else
			intLength=intLength+1; 
	}
	return intLength

};

//计算某个元素在数组中的位置
Array.prototype.indexOf=function(o){
	for(var i=0;i<this.length;i++){
		if(this[i]==o)
			return i;
	}
	return-1;
};

//计算某个元素在数组中最后的位置
Array.prototype.lastIndexOf=function(o){
	for(var i=this.length-1;i>=0;i--){
		if(this[i]==o)
			return i;
	}
	return-1;
};

//判断数组是否包含某个元素
Array.prototype.contains=function(o){
	return this.indexOf(o)!= -1;
};

//向数组增加一个数组中所有元素
Array.prototype.addAll=function(newArray){
	for(var i=0;i<newArray.length;i++){
		this.push(newArray[i]);
	}
};

//合并数组
Array.prototype.merge = function(newArray){
	for(var i=0;i<newArray.length;i++){
		if(this.contains(newArray[i])==false)
			this.push(newArray[i]);
	}
};


//复制数组
Array.prototype.copy=function(o){
	return this.concat();
};

//在数组指定位置插入元素
Array.prototype.insertAt=function(o,i){
	this.splice(i,0,o);
};

//在数组中某元素之前插入新元素
Array.prototype.insertBefore=function(o,o2){
	var i=this.indexOf(o2);
	if(i== -1)
		this.push(o);
	else
		this.splice(i,0,o);
};

//删除指定位置的元素
Array.prototype.removeAt=function(i){
	this.splice(i,1);
};

//删除指定元素
Array.prototype.remove=function(o){
	var i=this.indexOf(o);
	if(i!= -1)
		this.splice(i,1);
};


/**
* 把数字按格式变成字符串
* 1、#.00,保留2位小数
* 2、#.00%,保留2位小数的百分数
* 3、##.00,保留2位小数，2位整数，整数不足部分补零
**/
Number.prototype.format = function(f){
	var n = this;
	f = f.trim();
	if(f==null)	f = "#.00";
	var isPercent = false;
	if(f.endsWith("%")){
		isPercent = true;
		n = n*100;
		f = f.substring(0,f.length-1);
	}
	var v ;
	if(f.startsWith("#") && f.indexOf(".")<0){
		v = String(Math.round(n));	//返回整数
		var l = f.length-v.length;
		if(l>0){
			for(var i=0;i<l;i++)
				v = "0"+v;
		}
	}else if(f=="#.#"){
		v = ""+n;
	}else{
		var pre = 0;	//小数点之前的长度
		var preStr = "";
		var after = 0;	//小数点之后的长度
		var afterStr = "";
		
		if(f.endsWith("#")){
			after = 0;		//小数点后有几位就是几位，不补零
			v  = ""+n;
		}else{
			var index = f.indexOf(".");
			pre = index;
			preStr = f.substring(0,index);
			afterStr = f.substring(index+1);
			after = afterStr.length;
			
			
			var p = Math.pow(10,after);
			var t = p * n;
			t = Math.round(t);
			v = String(t / p);
		}	
		
		var vpre = "";
		var vafter = "";
		if(after>0){
			if(v.indexOf(".")===-1){
				v = v+".0";
			}
			var p = v.indexOf(".")+1;
			var vafter = v.substring(p);
			if(vafter.length<after){
				var l = after-(vafter.length);
				for(var i = 0;i<l;i++){
					vafter = vafter+"0";
				}
			}
		}
		if(pre>0){
			if(v.indexOf(".")===-1){
				v = v+".0";
			}
			var p = v.indexOf(".");
			var vpre = v.substring(0, p);
			if(vpre.length<pre){
				var l = pre-(vpre.length);
				for(var i = 0;i<l;i++){
					vpre = "0"+vpre;
				}
			}
		}
		v = vpre+"."+vafter;
	}
	if(isPercent===true){
		v = v+"%";
	}
	
	return v;
};

CSST = {};
CSST.Reg4Property = new RegExp("^\\w+\\[\\w+\\]$");
CSST.UI = {};
CSST.UI.getPropertyFromMap=function(obj,pName){
	var ss = pName.split("[");
	var s = ss[0];
	ss[1]=ss[1].substring(0,ss[1].length-1);
	var value = obj[s];
	
	if(value==null)
		return value;
	else
		return value[ss[1]];
}

CSST.UI.getProperty=function(obj,pName){	
	var pNames = pName.split(".");
	var value = obj;
	for(var i=0;i<pNames.length;i++){
		if(value==null)
			return value;
		pNames[i] = pNames[i].trim();
		if(CSST.Reg4Property.test(pNames[i])){
			value = CSST.UI.getPropertyFromMap(value, pNames[i]);
		}else{
			value = value[pNames[i]];
		}
	}
	return value;
}

CSST.UI.setProperty = function(obj,pName,pValue){
	var pNames = pName.split(".");
	var value = obj;
	for(var i=0;i<pNames.length;i++){
		pNames[i] = pNames[i].trim();
		if(CSST.Reg4Property.test(pNames[i])){
			value = CSST.UI.setPropertyForMap(value, pNames[i],pValue);
		}else{
			if(i==pNames.length-1)
				value[pNames[i]] = pValue;
			else{
				var c = value[pNames[i]];
				if(c==null){
					c = {};
					value[pNames[i]] = c;					
				}
				value = c;
			}
		}
	}
};

CSST.UI.setPropertyForMap=function(obj,pName,pValue){
	var ss = pName.split("[");
	ss[1]=ss[1].substring(0,ss[1].length-1);
	var childOfObj = obj[ss[0]];
	if(childOfObj==null)
		obj[ss[0]]={};	
	obj[ss[0]][ss[1]]=pValue;
}

CSST.UI.getNextId = function(){
	if(this.domObjectId == null)
		this.domObjectId = 0;
	this.domObjectId ++;
	return this.domObjectId;
};

CSST.UI.TreeEvents = {
	onStateSwitch:function(treeId,nodeId){
		var tree = CSST.UI.trees[treeId];
		if(tree!=null){
			node = tree.getNode(nodeId);
			node.changeState();
			tree.onStateChanged(node);
		}
	},

	onNodeClicked:function(treeId,nodeId){
		var tree = CSST.UI.trees[treeId];
		if(tree!=null){
			node = tree.getNode(nodeId);
			node.focus();
			tree.onChanged(node);

		}
	}
};

CSST.UI.trees = {};
CSST.UI.Tree = function(parent,context,data){	
	this.context = context;
	this.focusedNode = null;
	this.selectedNodes = [];

	if(parent.constructor == String) 
		parent = $("#"+parent);
	else 
		parent = $(parent);

	parent.addClass("CSST_Tree");
	this.id = parent.attr("id");
	CSST.UI.trees[this.id] = this;	//注册一颗树，便于根据id找回这棵树

	if(this.id==null)
		this.id = "CSST_UI_Tree_"+CSST.UI.getNextId();
	parent.attr("id",this.id);

	this.children = [];
	if(data instanceof Array){
		this.data = data;
	}else{
		this.data= [];
		this.data.push(data);
	}

	for(var i=0;i<this.data.length;i++){
		var node = new CSST.UI.TreeNode(this.data[i],this);
		this.children.push(node);
		
	}
	for(var i=0;i<this.children.length;i++){
		this.children[i].paint();
	}

	this.getNode = function(nodeId){
		for(var i=0;i<this.children.length;i++){
			var child = this.children[i];
			if(child.id == nodeId)
				return child;
			else{
				var cc = child.getChildNode(nodeId);
				if(cc!=null)
					return cc;
			}
		}
		return null;
	};

	
	this.onStateChanged = function(node){
		
	};

	this.onChanged = function(node){
		
	};

	this.getSelectedNode = function(){
		if(this.selectedNodes!=null && this.selectedNodes.length>0){
			return this.selectedNodes;
		}else{
			return this.focusedNode;
		}
	};

	this.remove = function(node){
		node.remove();
	};

	this.addNode = function(data){
		var preNode = this.children[this.children.length-1];
		var node = new CSST.UI.TreeNode(data,this);
		this.children.push(node);
		node.paint();
		preNode.paint();
	};
	
	this.insertBefore = function(data,node){
		var parent = node.parent;
		if(parent==this){
			var p = this.children.indexOf(node);
			var newNode = new CSST.UI.TreeNode(data,this);
			this.children.insertAt(node, p);
			newNode.paint();
			node.paint();
			newNode.getElement().insertBefore(node.getElement());
		}else{
			parent.insertBefore(data,node);
		}
	};
	
	this.findNode = function(propertyName,value){	
		var iterator = this.getIterator();
		var node = null;
		while((node=iterator.next())!=null){
			if(node.data[propertyName]==value){
				return node;
			}
		}
		return null;
	};
	
	this.getIterator = function(){
		return new CSST.UI.Tree.Iterator(this);
	};
	
};

CSST.UI.Tree.Iterator = function(tree){
	if(tree.children==null || tree.children.length<1)
		return null;
	
	this.tree = tree;
	this.current = tree;
	
	this.next = function(){
		var children = this.current.children;
		if(children!=null && children.length>0){
			this.current =children[0];
		}else{
			if(this.current==this.tree)
				this.current = null;
			else
				this.current = this.getNextBrother(this.current);
		}
		return this.current;
	};

	this.getNextBrother = function(current){
		var brothers = current.parent.children;
		var index = brothers.indexOf(current);
		if(index<brothers.length-1){
			return brothers[index+1];
		}else{
			if(current.parent == this.tree){
				return null;
			}else{
				return this.getNextBrother(current.parent);
			}
		}
	};
};

CSST.UI.TreeNode = function(data,parent){
	this.data = data;
	this.parent = parent;
	this.children = [];
	this.state = "closed";
	this.focused = false;
	this.id = CSST.UI.getNextId();
	this.getChildNode = function(nodeId){
		if(this.children!=null && this.children.length>0){
			for(var i=0;i<this.children.length;i++){
				var child = this.children[i];
				if(child.id == nodeId)
					return child;
				else{
					var cc = child.getChildNode(nodeId);
					if(cc!=null)
						return cc;
				}
			}					
		}	
		return null;
	};
	
	this.moveTo = function(index){
		var brothers = this.parent.children;
		var oldIndex  = brothers.indexOf(this);
		if(index>brothers.length-1||index<0){
			alert("超出范围");
		}
		brothers.remove(this);
		brothers.insertAt(this,index);
		if(index == brothers.length-1){//移动到最后面
			this.getElement().appendTo(this.getContainer());
			this.getChildrenBox().appendTo(this.getContainer());
			this.paint();
			if(this.getChildrenBox().length>0)	
				this.refreshNodesHead(this.children);
			//原先的最后节点要重新绘制
			var brother = brothers[brothers.length-2];
			brother.paint();
			if(brother.getChildrenBox().length>0)
				brother.refreshNodesHead(brother.children);
		}else{	//移动到中间某个位置
			
			var brother = brothers[index+1]; //新位置之后的兄弟节点
			this.getElement().insertBefore(brother.getElement());
			var cbox = this.getChildrenBox();
			if(cbox!=null)
				cbox.insertBefore(brother.getElement());
			if(oldIndex==brothers.length-1){
				var newLastBrother = brothers[oldIndex];
				newLastBrother.paint();
				if(newLastBrother.getChildrenBox().length>0)
					newLastBrother.refreshNodesHead(newLastBrother.children);
				this.paint();
				if(this.getChildrenBox().length>0)
					this.refreshNodesHead(this.children);
			}
		}
	}
	
	
	
	this.moveDown = function(){
		var brothers = this.parent.children;
		var currentIndex  = brothers.indexOf(this);
		if(currentIndex >= brothers.length-1)
			return ;

		var brother = brothers[currentIndex+1];
		//调换json对象的位置
		brothers[currentIndex]=brother;
		brothers[currentIndex+1]=this;
		//调换dom对象的位置
		brother.getElement().insertBefore(this.getElement());
		brother.getChildrenBox().insertBefore(this.getElement());
		this.paint();
		brother.paint();
		
		if(this.getChildrenBox().length>0)	//兄弟节点的子节点已经绘制，则需要重新绘制
			this.refreshNodesHead(this.children);
		if(brother.getChildrenBox().length>0)	//兄弟节点的子节点已经绘制，则需要重新绘制
			this.refreshNodesHead(brother.children);
	}
	
	this.moveUp = function(){
		var brothers = this.parent.children;
		var currentIndex  = brothers.indexOf(this);
		if(currentIndex <=0)
			return ;
		var brother = brothers[currentIndex-1];
		brother.moveDown();
	}
	
	
	this.remove = function(){
		if(this.isRoot()){
			alert("不允许删除根节点");
			return ;
		}
		var isLast = this.isLast();
		
		if(this.getTree().focusedNode==this)
			this.getTree().focusedNode = null;
		if(this.getTree().selectedNodes!=null){
			this.getTree().selectedNodes.remove(this);
		}

		this.getElement().remove();
		this.getChildrenBox().remove();

		this.parent.children.remove(this);
		
		if(isLast && this.parent.children.length>0){
			//重绘新成为最后一个兄弟节点的节点
			var lastBrother = this.parent.children[this.parent.children.length-1];
			lastBrother.paint();
			if(lastBrother.getChildrenBox().length>0)	//兄弟节点的子节点已经绘制，则需要重新绘制
				this.refreshNodesHead(lastBrother.children);
		}

		if(this.parent.children.length==0){
			this.parent.paint();
			this.parent.getChildrenBox().remove();
		}

		this.parent = null;
		this.children = null;
	};

	//重绘兄弟节点的子节点头部
	this.refreshNodesHead = function(nodes){
		if(nodes!=null && nodes.length>0){
			for(var i=0;i<nodes.length;i++){
				var node = nodes[i];
				node.paint();
				if(node.getChildrenBox().length>0)
					this.refreshNodesHead(node.children);
			}
		}
	};
	
	this.insertBefore = function(data,node){
		var current = new CSST.UI.TreeNode(data,this);
		this.children.insertBefore(current, node);
		this.paint();
		if(this.children.length>1){
			node.paint();	//重绘兄弟节点
			if(node.getChildrenBox().length>0){	//兄弟节点的子节点已经绘制，则需要重新绘制
				this.refreshNodesHead(node.children);
			}
		}
		this.open();
		if(current.getElement().length==0){
			current.paint();
			current.getElement().insertBefore(node.getElement());
		}
	};
	
	
	this.addChild = function(data){
		var node = new CSST.UI.TreeNode(data,this);
		this.children.push(node);
		this.paint();
		if(this.children.length>1){
			var preBrother = this.children[this.children.length-2];
			preBrother.paint();	//重绘兄弟节点
			if( preBrother.getChildrenBox().length>0){	//兄弟节点的子节点已经绘制，则需要重新绘制
				this.refreshNodesHead(preBrother.children);
			}
		}
		this.open();
		if(node.getElement.length==0)
			node.paint();
		
	};
	
	/**
	 * 更新当前节点的内容，不影响子节点
	 * @param data
	 */
	this.update = function(data){
		for(var key in data){
			if(key!="children"){
				this.data[key] = data[key];
			}
		}
		this.paint();
	}
	

	this.changeState = function(){				
		if(this.state=="closed"){
			this.open();
		}else{
			this.close();
		}
	};
	
	this.blur = function(){
		this.focused = false;
		this.getTitleBox()[0].className="title";
	};
	

	this.focus = function(){				
		if(this.getTree().focusedNode!=null){
			this.getTree().focusedNode.blur();
		}
		this.getTree().focusedNode = this;
		this.focused = true;
		this.getTitleBox()[0].className="focus";
	};

	this.getTree = function(){
		if(this.parent.constructor == CSST.UI.Tree)
			return this.parent;
		else 
			return this.parent.getTree();
	};


	//子节点由哪个属性决定
	var childProperty = this.getTree().context["children"];
	var childData = data[childProperty];
	
	
	if(childData!=null && childData.length>0){
		for(var i=0;i<childData.length;i++){
			var child = new CSST.UI.TreeNode(childData[i],this);
			this.children.push(child);
		}
	}
	
	
	//父节点的childrenBox
	this.getContainer = function(){				
		var containerId = null;
		if(this.parent.constructor == CSST.UI.Tree){
			containerId = this.parent.id;
		}else{
			containerId = "CSST_UI_Tree_Children_"+this.parent.id;
		}

		var container = $("#"+containerId);
		return container;
	};

	this.hasChildren = function(){
		if(this.children!=null && this.children.length>0)
			return true;
		else 
			return false;
	};

	this.isLast = function(){
		var index = this.parent.children.indexOf(this);
		if(index==this.parent.children.length-1)
			return true;
		return false;
	};

	this.isFirst = function(){
		var index = this.parent.children.indexOf(this);
		if(index ==0)
			return true;
		return false;
	};

	this.isRoot = function(){
		if(this.parent.constructor==CSST.UI.Tree && this.parent.children.indexOf(this)==0)				
			return true;
		return false;
	};

	//当前节点的dom
	this.getElement = function(){
		var e = $("#CSST_UI_Tree_Node_"+this.id);
		return e;
	};

	

	this.getChildrenBox = function(){
		var e = $("#CSST_UI_Tree_Children_"+this.id);
		return e;
	};
	
	this.getTitleBox = function(){
		var e = $("#CSST_UI_Tree_Title_"+this.id);
		return e;
	};
	
	//向上递归父节点
	this.paintHead = function(node){
		var sb = [];
		var className = "";
		var className4Img = "";
		var evtStr = "";
		if(node==null){
			if(this.hasChildren()){	
				if(this.isRoot()){
					if(this.getTree().children.length>1){
						if(this.state=="opened"){
							className="minus_top";
						}else{
							className="plus_top";
						}
					}else{
						if(this.state=="opened"){
							className="minus_root";
						}else{
							className="plus_root";
						}
					}
				}else if(this.isLast()){
					if(this.state=="opened"){
						className="minus_bottom";
					}else
						className="plus_bottom";
				}else if(this.isFirst()){	
					if(this.state=="opened"){
						className="minus_center";
					}else{
						className="plus_center";								
					}
				} else{
					if(this.state=="opened"){
						className="minus_center";
					}else
						className="plus_center";
				}
			}else{
				if(this.isLast()){
					className="line_bottom";	
				}else if(this.isFirst()){
					className="line_center";
				}else{
					className="line_center";
				}
			}
			node = this;
			var treeId = this.getTree().id;
			var nodeId = this.id;

			if(node.hasChildren())
				evtStr = 'onclick="CSST.UI.TreeEvents.onStateSwitch(\''+treeId+'\','+nodeId+')"';

		}else{
			if(node.isLast())
				className = "blank";
			else
				className = "line_conn";
		}
		
		if(this.hasChildren())
			className4Img = node.state=="opened"?"open":"close";
		else
			className4Img = "page";
		
		sb.push("<div class='"+className+"' ");
		sb.push( evtStr);
		sb.push("></div>");
		if(node==this){
			sb.push("<div class='"+className4Img+"' ");
			sb.push( evtStr);
			sb.push("></div>");
		}

		if(node.parent.constructor==CSST.UI.TreeNode)
			sb.insertAt(this.paintHead(node.parent),0);

		
		return sb.join("");
	};
	
	//绘制当前节点
	this.paint = function(){
		var viewPropertyName = this.getTree().context.view;
		var element = this.getElement();
		if(element.length==0){
			element = $("<div/>");
			element.attr("id", "CSST_UI_Tree_Node_"+this.id);
			element.addClass("Node");
			this.getContainer().append(element);
			var sb = [];
			sb.push("<div class='title' ");
			sb.push("onclick='CSST.UI.TreeEvents.onNodeClicked(\""+this.getTree().id+"\","+this.id+")'");
			sb.push("id='CSST_UI_Tree_Title_"+this.id);
			sb.push("'>"+this.data[viewPropertyName]);
			sb.push("</div>");
			var head = this.paintHead();
			sb.insertAt(head,0);
			element.html(sb.join(""));

		}else{	//重绘节点本身(不含子节点)
			var sb = [];
			sb.push("<div class='title' ");
			sb.push("onclick='CSST.UI.TreeEvents.onNodeClicked(\""+this.getTree().id+"\","+this.id+")'");
			sb.push("id='CSST_UI_Tree_Title_"+this.id);
			sb.push("'>"+this.data[viewPropertyName]);
			sb.push("</div>");
			var head = this.paintHead();
			sb.insertAt(head,0);
			element.html(sb.join(""));
			if(this.focused){
				this.getTitleBox()[0].className="focus";
			}
		}

		var items = element.children() ;
		var len = 2;
		
		for(var i=0;i<items.length;i++){
			var item = items[i];					
			if(item.className=="title" || item.className=="focus")
				len += this.data[viewPropertyName].asciiLen()*6+4;
			else
				len += 16;		
			}
		element.width(len);
	};
	
	//关闭当前节点
	this.close = function(){
		var childrenBox = this.getChildrenBox();
		if(childrenBox.length>0){
			childrenBox.css("display","none");
		}
		var titleBox  = this.getTitleBox();
		var imgBox = titleBox.prev();
		var lineBox = imgBox.prev();
		if(this.isRoot()){
			if(this.parent.children.length>1){
				lineBox.attr("class","plus_top");
			}else
				lineBox.attr("class", "plus_root");
		}else if(this.isLast()) {
			lineBox.attr("class","plus_bottom");
		}else{
			lineBox.attr("class","plus_center");
		}
		imgBox.attr("class","close");

		this.state = "closed";
	};

	//展开当前节点
	this.open = function(){
		if(this.children==null || this.children.length<1)
			return ;
		var element = this.getElement();
		var title = this.getTitleBox();
		var imgBox = title.prev();
		var lineBox = imgBox.prev();

		this.state = "opened";
		imgBox.attr("class","open");
		if(this.isRoot()){
			if(this.parent.children.length>1)
				lineBox.attr("class","minus_top");
			else
				lineBox.attr("class","minus_root");
		}else if(this.isLast()){
			lineBox.attr("class","minus_bottom");
		}else{
			lineBox.attr("class","minus_center");
		}
		
		var childrenBox = this.getChildrenBox();
		if(childrenBox.length>0){
			childrenBox.css("display","");
			return;
		}
		
		
		childrenBox = $("<div></div>");
		childrenBox.attr("id", "CSST_UI_Tree_Children_"+this.id);
		childrenBox.addClass("childrenBox");
		
		childrenBox.insertAfter(element);
		for(var i=0;i<this.children.length;i++){
			var child = this.children[i];
			child.paint();
		}
	};
};



CSST.UI.DefaultAlign = {
	"String":"left",
	"Link":"center",
	"Number":"right",
	"Boolean":"center",
	"Select":"center",
	"Date": "center",
	"undefined": "left",
	"null": "left"
};

CSST.UI.CellRenders = {
	"String":{
		render:function(grid,row,col){
			var data = row.getCellValue(col);
			if(data===null ||  data===undefined){
				return "&nbsp;";
			}
			data = data+"";
			data=data.replace("<","&lt;");
			data=data.replace(">","&gt;");
			return data;
		}
	},
	"Number":{
		render:function(grid,row,col){
			var data = row.getCellValue(col);
			var n = new Number(data);
			var r ;
			if(!isFinite(n)) n = new Number(0);
			if(col.format!=null) 
				r = n.format(col.format);
			else
				r = n;
			return r;
		}
	},
	"Boolean":{
		render:function(grid,row,col){
			var data = row.getCellValue(col);
			var c = (data===true)?'是':'否';
			return c;
		}
	},
	"Link":{
		render:function(grid,row,col){
			var data = row.getCellValue(col);
			if(data===null || data===undefined) data = "";
			var t=[];
			t.push('<a style="TEXT-DECORATION: underline;cursor:pointer;"');
			t.push(' href="s_grid_onCellLink(\''+grid.id+'\',\''+row._index+'\',\''+col.name+'\');">');
			t.push(data);
			t.push('</a>');
			return t.join('');
		}
	},
	"Select":{
		render: function(grid,row,col){
			var id = row.getCellValue(col);
			var options = col.options;
			var value = null;
			for(var i=0;i<options.length;i++){
				if(options[i].id == id) {
					value=options[i];
					break;
				}
			}
			if(value!=null) return value.name;
			else return "&nbsp;";
		}
	},
	"Date":{
		render:function(grid,row,col){
			var date = row.getCellValue(col);
			if(date===null ||  date===undefined){
				date = "&nbsp;";
			}
			else{
				var text = new Date(date);
				if (text != "") {
					// 处理Date格式yyyy-MM-dd
					var day = text.getFullYear() + "-" + (text.getMonth()+1).format("##") + "-" + text.getDate().format("##");
					// 处理Time格式HH:mm:ss
					var time = text.getHours().format("##") + ":" + text.getMinutes().format("##") + ":" + text.getSeconds().format("##");
					if(col.format==null){
						date = day + " " + time;
					}else if(col.format.trim()=="yyyy-MM-dd"){
						date = day;
					}else if(col.format.trim()=="HH:mm:ss"){
						date = time;
					}else{
						date = day + " " + time;
					}
				}
			}
			return date;
		}
	}
};

CSST.UI.GridEvents = {
	onCellLink:function(gridId,rowIndex,colName){
		
	},
	RowsChecked:function(gridId,inputObj){
		if(inputObj.checked){
			$(inputObj).parent().addClass("csstChecked");
		}else{
			$(inputObj).parent().removeClass("csstChecked");
		}
		var grid = CSST.UI.Grids[gridId];
		var rows = grid.rows;
		for(var i=0;i<rows.length;i++){
			rows[i].setSelected(inputObj.checked);
		}
	},
	onRowClicked:function(gridId,rowIndex){
		var grid = CSST.UI.Grids[gridId];
		var row = grid.getRowByIndex(rowIndex);
		if(grid.context.selectedMode=="S"){	//单选
			var rows = grid.getSelectedRows();
			for(var i=0;i<rows.length;i++){
				if(rows[i]!=row)
					rows[i].setSelected();
			}
		}		
		row.setSelected();
		grid.refreshHeadSelectStatus();
	},
	onPageChange:function(gridId,select){
		var grid = CSST.UI.Grids[gridId];
		var pageSize = 1*select.options[select.selectedIndex].text ;
		grid.gotoPage(pageSize,0);
		grid.refreshHeadSelectStatus();
	}
};
CSST.UI.Grids = {};
CSST.UI.Grid = function(box,columns,context){
	this.grid = this;
	this.cols = columns;
	this.rows = [];
	this.context = context;
	var element = null;
	if(typeof(box)=="string" ){
		element =$("#"+box);
	}else{
		element = $(box);
	}
	this.id = element.attr("id");
	
	if(this.id==null || this.id.length<1){
		this.id = CSST.UI.getNextId();
		element.attr("id",this.id);
	}	
	CSST.UI.Grids[this.id] = this;
	
	element.html("");
	element.addClass("CSST_Grid");	
	
	this.headWide = null;
	this.headDeep = null;
	this.headHeight = null;
	this.bodyHeight = null;
	this.colsWidth = null;
	this.renders = {};
	
	var sb = [];
	sb[sb.length] = '<div id="head_' + this.id + '"  class="head" style="width:5000px;">';
	sb[sb.length] = '表头区域';
	sb[sb.length] = '</div>';
	sb[sb.length] = '<div id="body_' + this.id + '"  class="body" style="width:500px;overflow:auto;">';
	sb[sb.length] = '表体区域';
	sb[sb.length] = '</div>';
	if(this.context==null)
		this.context = {};
	if(this.context.pageController==null){
		
	}else{
		sb[sb.length] = '<div id="page_' + this.id + '"  class="pageBox" style="width:500px;">';
		sb[sb.length] = '分页区域';
		sb[sb.length] = '</div>';
	}
	element.html(sb.join(""));
	
	element.css("padding","0px");
	element.css("margin","0px");
	
	
	this.refreshHeadSelectStatus = function(){
		var selectedAll = true;
		var oInput = $("#tHead_"+this.id).find("input[type=checkbox]");
		for(var i=0;i<this.rows.length;i++){
			var row = this.rows[i];
			if(!row.selected){
				selectedAll=false;
				break;
			}
		}
		if(this.context.selectedMode!="S" ){
			oInput[0].checked = selectedAll;
			if(selectedAll){
				oInput.parent('span.CheckboxWrapper').addClass("csstChecked");
			}else{
				oInput.parent('span.CheckboxWrapper').removeClass("csstChecked");
			}
		}
	}
	
	
	
	this.getElement = function(){
		return $("#"+this.id);
	};

	this.getHeadBox = function(){
		return $("#head_"+this.id);
	};
	
	this.getHeadTable= function(){
		return $("#tHead_"+this.id);
	};
	
	this.getBodyTable = function(){
		return $("#tBody_"+this.id);
	};
	
	this.getBodyBox= function(){
		return $("#body_"+this.id);
	};
	
	this.getPageBox = function(){
		return $("#page_"+this.id);
	};

	/**
	 * 获得列宽
	 */
	this.getColWidth = function(col){
		if(col.width!=null)
			return col.width;
		else 
			return 100;
	};
	
	/**
	 * 获得整个表的宽度
	 */
	this.calcTableWidth = function(){
		var width = 0;
		var end = 0;
		if(this.leafCols[this.leafCols.length-1].caption=="&nbsp;")
			end = this.leafCols.length-1;
		else
			end = this.leafCols.length ;
		
		for(var i=0;i<end ;i++){
			width = width+1*this.getColWidth(this.leafCols[i])+1;
		}		
		if(this.context.selectedMode!='S')
			width +=37;
		return width;
	};
	
	/**
	 * 根据容器和列宽度的合计值，决定是否新增一个空白列
	 */
	this.resetColumns = function(){
		var colsWidth = this.calcTableWidth();
		var containerWidth = this.getElement().width();
		if(containerWidth>colsWidth+50){
			var col = {};
			col.type = "String";
			col._rowspan = this.countHeadDeep();
			col._colspan = 1;
			col.caption = "&nbsp;";
			this.leafCols.push(col);
			this.cols.push(col);
		}
	}
	/**
	 * 根据滚动情况调整最后一列的宽度
	 */
	this.resetLastColumnWidth=function(){
		var bodyBox = this.getBodyBox();
		var bodyTable = this.getBodyTable();
		var colsWidth = this.calcTableWidth();
		var containerWidth = this.getElement().width();
		//如果存在为了适应宽度而生成的列
		if(this.leafCols[this.leafCols.length-1].caption=="&nbsp;"){
			
		}
	}
	
	
	
	/**
	 * 计算表头单元格占据几行
	 */
	this.calcHeadCellRowSpan = function(cols,deep){
		if(cols===undefined){
			cols = this.cols;
			deep = this.countHeadDeep();
		}
		for(var i=0;i<cols.length;i++){
			var col = cols[i];
			col._rowspan = deep-col._deep+1;
			var children = col.children;
			if(children!==undefined && children.length>0){
				this.calcHeadCellRowSpan(children,deep-1);
			}
		}
	};
	
	/**
	 * 计算表头深度
	 */
	this.countHeadDeep= function(){
		if(this.headDeep!==null)
			return this.headDeep;
		var children = this.cols;
		var maxDeep = 0;
		if(children!=null && children.length>0){
			for(var i=0;i<children.length;i++){
				var col = children[i];
				var deep = this.countColDeep(col);
				if(deep>maxDeep){
					maxDeep = deep;
				}
			}
		}
		this.headDeep = maxDeep;
		return this.headDeep;
	};
	
	/**
	 * 计算当前列向下数共有多少层
	 */
	this.countColDeep= function(col){
		var children = col.children;
		var maxDeep = 0;
		if(children!=null && children.length>0){			
			for(var i=0;i<children.length;i++){
				var child = children[i];
				var deep = this.countColDeep(child);
				if(deep>maxDeep){
					maxDeep = deep;
				}
			}
		}
		col._deep =  maxDeep +1;
		return maxDeep+1;
	};
	
	/**
	 * 计算表总共多少列，因为子列的存在，不能用columns.length来获得
	 */
	this.countHeadWide= function(){
		if(this.headWide !=null)
			return this.headWide;
		var wide = 0;
		this.leafCols = [];	//表头的叶子节点
		var children=this.cols;
		if(children!=null && children.length>0){
			for(var i=0;i<children.length;i++){
				var col = children[i];
				col.parent = null;
				wide = wide + this.countColWide(col);
			}
		}
		this.headWide = wide;
		return wide;
	};
	
	/**
	 * 计算当前列包含多少叶子列
	 */
	this.countColWide = function(col){
		var children = col.children;
		if(children==null || children.length==0){
			col._colspan = 1;		
			this.leafCols.push(col);	//是叶子节点
		}else{
			col._colspan=0;
			for(var i=0;i<children.length;i++){
				var child = children[i];
				child.parent = col;
				child.brotherIndex = i;
				var cw = this.countColWide(child);
				col._colspan = col._colspan+cw;
			}
		}
		return col._colspan;
	};
	
	/**
	 * 获得column group
	 */
	this.getColGroup= function(n) {
		if(this.colGroup!=null) return this.colGroup;
		var ua = navigator.userAgent.toLowerCase();
		var isIE6 = false;
		if(ua.indexOf("msie 6.0")>0){
			isIE6 = true;
		};
		
		var sb = [];
		sb.push("<COLGROUP id='colgroup_"+this.id+"_"+n+"'>");
		if(this.context.selectedMode!="S")
			sb.push('<COL width="36"></COL>');
			
		for(var i=0;i<this.leafCols.length;i++){
			if(i==this.leafCols.length-1){
				sb.push("<COL></COL>");
			}else{
				var col = this.leafCols[i];
				sb.push('<COL width="');
				if(isIE6){
					if(col.parent!=null && col.brotherIndex>0 && n=="head"){
						sb.push(1*this.getColWidth(col)+5);
					}else{
						sb.push(this.getColWidth(col));
					}
				}else
					sb.push(this.getColWidth(col));
				
				sb.push('" ');
				sb.push('/>');
			}
			
		}
		sb.push("</COLGROUP>");
		this.leftColGroup = sb;
		
		return sb;
	};
	
	/**
	 * 绘制表头的一个单元格
	 */
	this.paintHeadCell = function(col,rowsbuf){
		var rowbuf = rowsbuf[col._selfDeep];
		var cellbuf = [];
		cellbuf.push('<TD style="text-align:center;"');
		cellbuf.push(' colspan='+col._colspan);
		cellbuf.push(' rowspan='+col._rowspan);
		cellbuf.push('>' + col.caption);
		cellbuf.push('</TD>');
		rowbuf[rowbuf.length] = cellbuf.join("");
		if(col.children!== undefined && col.children.length>0){
			var children = col.children;
			for(var i=0;i<children.length;i++){
				var child = children[i];
				child._selfDeep = col._selfDeep +1;
				this.paintHeadCell(child,rowsbuf);
			}
		}
	};
	
	/**
	 * 绘制表头
	 */
	this.paintHeader = function(){
		var sb = [];
		sb.push('<TABLE class="headTable" id=tHead_'+this.id+' style="TABLE-LAYOUT:fixed;" cellSpacing=0 cellPadding=0 border=0>');
		sb.push(this.getColGroup("head").join(""));
		
		var rowsbuf = [];
		var deep = this.countHeadDeep();
		for(var i=0;i<deep;i++){
			var rowbuf = [];
			rowsbuf.push(rowbuf);
			rowbuf.push('<TR>');	
			
		}	
		if(this.context.selectedMode!="S" ){
			rowsbuf[0].push('<td style="text-align:center;"');
			rowsbuf[0].push(' rowspan='+deep);
			rowsbuf[0].push('><span class="CheckboxWrapper"><input type="checkbox"  class="csstCheckbox" onclick="CSST.UI.GridEvents.RowsChecked(\''+this.id+'\',this)"> </span></td>');
		}
		for(var i=0;i<this.cols.length;i++){
			var col = this.cols[i];
			col._selfDeep = 0;
			this.paintHeadCell(col,rowsbuf);
		}
		for(var i=0;i<deep;i++){
			var rowbuf = rowsbuf[i];
			rowbuf.push('</TR>');
			rowsbuf[i]=rowbuf.join("");
		}
		sb.push(rowsbuf.join(""));
		sb.push('</TABLE>');
		return sb.join("");
	};
	
	this.paintPageBox = function(col){
		if(this.context.pageController!=null){			
			var pageBar = $("<div>")
				.attr("id","pageBar_"+this.id)
				.addClass("pageBar");
			this.getPageBox().html("");
			this.getPageBox().append(pageBar);
			var sizeSelector = $("<select onchange='alert(\""+this.id+"\");CSST.UI.GridEvents.onPageChange(\""+this.id+"\",this)'>");
			sizeSelector.attr("id","pageSize_"+this.id);
			sizeSelector.html("<option>10</option><option>15</option><option>20</option><option>30</option>");
			pageBar.append(sizeSelector);		
			
		}
	};
	
	this.gotoPage = function(pageSize,pageIndex){
		var fn = this.context.pageController.pageRead;
		fn = fn.substring(0,fn.indexOf("("));
		fn = fn+"("+pageSize+","+pageIndex+")";
		var page = eval(fn);
		this.bindPage(page);
		this.grid.refreshHeadSelectStatus();
	}
	
	this.insertPageNo = function(no){
		var p = $("<span>");
		p.html(no);
		this.pageBar.append(p);
		if(isNaN(no)==false){
			p.bind("click",function(){
				var span = $(this);
				var index = 1*span.html()-1;
				var pageBar = span.parent();
				var id = pageBar.attr("id");
				id = id.substring(8);
				var grid = CSST.UI.Grids[id];
				grid.gotoPage(grid.currentPage.size,index);
			});
		}
	};
	
	this.refreshPageBox = function(page){
		var pageBar = $("#pageBar_"+this.id);
		pageBar.html("");
		this.pageBar = pageBar;
		var sections = [];
		
		sections.push([0,1]);
		sections.push([page.index-1,page.index,page.index+1]);
		sections.push([page.amount-2,page.amount-1]);
		
		
		if(sections[1][0]-sections[0][1]<=2){	//如果第一段和第二段距离很近，则合并这两段
			if(sections[1][0]<0){
				sections[1][0]=0;
				sections[1][1]=1;
				sections[1][2]=2;
			}
			sections[0] = [];
			for(var i=0;i<=sections[1][2];i++){
				sections[0].push(i);
			}
			sections.removeAt(1);
		}		
		
		var pre = sections[sections.length-2];
		var next = sections[sections.length-1];
		if(next[0]-pre[pre.length-1]<=2){	//如果第二段和第三段距离比较近，则合并这两段
			if(next[0]<0)
				next[0] = 0;
			if(next[1]<0)
				next.removeAt(1);
			var j = 0;
			for(var i=pre[0];i<=next[next.length-1];i++){
				pre[j] = i;
				j = j+1;
			}
			sections.remove(next);
		}
		if(page.amount==0){
			sections = [];
		}
		
		var end = page.amount -1;
		for(var i=0;i<sections.length;i++){
			while(sections[i][sections[i].length-1]>end){
				sections[i].removeAt(sections[i].length-1);
			}
			if(i!=0)
				this.insertPageNo("...");
			for(var j=0;j<sections[i].length;j++){
				this.insertPageNo(sections[i][j]+1);
			}
		}
		
		var sizeSelector = $("<select class='pageSelect' onchange='CSST.UI.GridEvents.onPageChange(\""+this.id+"\",this)'>");
		sizeSelector.attr("id","pageSize_"+this.id);
		
		var sb = [];
		sb.push("<option "+(page.size==10?"selected":"")+">10</option>");
		sb.push("<option "+(page.size==15?"selected":"")+">15</option>");
		sb.push("<option "+(page.size==20?"selected":"")+">20</option>");
		sb.push("<option "+(page.size==30?"selected":"")+">30</option>");
		sizeSelector.html(sb.join(""));
		pageBar.append(sizeSelector);
		
		var spans = $("#pageBar_"+this.id+" > span");
		for(var i=0;i<spans.length;i++){
			var span =$(spans[i]);
			if(span.html()==""+(page.index+1)){
				span.addClass("current");
			}
		}
		
	};
	
	this.bindPage = function(page){
		this.currentPage = page;
		this.bind(page.elements);
		this.refreshPageBox(page);
	};
	
	
	this.getCellRender = function(col){
		if(col.render==null){
			var r = CSST.UI.CellRenders[col.type];
			col.render = r;
		}
		return col.render;
	}
	this.getColumnAlign = function(col){
		var align = "center";
		if(col.align!=null)	align = col.align;
		else align = CSST.UI.DefaultAlign[col.type];
		return align;
	};
	
	
	this.layout = function(){
		var container = this.getElement();
		var bodyBox = this.getBodyBox();
		var headTable = this.getHeadTable();
		var headBox = this.getHeadBox();
		var pageBox = this.getPageBox();
		var pageHeight = 0;
		var containerWidth = container.innerWidth();
		var tbWidth = this.calcTableWidth();
		
		if(pageBox.length>0)
			pageHeight = pageBox.height();
		
		headBox.height(headTable.height());
		bodyBox.width(container.innerWidth()-2);
		pageBox.width(container.innerWidth());
		bodyBox.height(container.innerHeight()-headBox.height()-pageHeight);
		
		var bodyTable = this.getBodyTable();
		if(bodyTable.length>0){	//如果数据已经绑定
			if(bodyTable.height()>bodyBox.innerHeight()){
				containerWidth = containerWidth-17;
			}
		}
		var width = tbWidth>containerWidth?tbWidth:containerWidth;
		headTable.width(width-2);
		bodyTable.width(width-2);
		if ($.browser.msie){
			headTable.width(width-4);
			bodyTable.width(width-4);
		}
	};
	$(document).bind("CSSTResize",function(){
		var frame=window.frameElement;
		var id ;
		if(frame!=null){
			id = frame.id;
			if(id.startsWith("dlgFrame_")==false){
				CSST.UI.Grids[element.attr("id")].layout();
			}
		}		
	});
	
	this.countHeadWide();
	this.countHeadDeep();
	this.calcHeadCellRowSpan();
	this.resetColumns();
	var headerStr = this.paintHeader();
	this.getHeadBox().html(headerStr);
	this.paintPageBox();
	this.layout();
	this.getBodyBox().bind("scroll",function(){
		 var bodyBox =  $(this);
		 var id = bodyBox.attr("id");
		 id = id.substring(5);
		 var grid = CSST.UI.Grids[id];
		 grid.getHeadTable().css("margin-left",-bodyBox.scrollLeft());
	});
	
	
	this.paintRows = function(){
		var rows = this.rows;
		var sb = new Array();
		sb.push('<TABLE  class="bodyTable" id=tBody_'+this.id+' style="TABLE-LAYOUT:fixed;" cellSpacing=0 cellPadding=0 border=0>');
		sb.push(this.getColGroup("body").join(""));
		for(var i=0;i<rows.length;i++){
			var str = rows[i].paint();
			sb.push(str);
		}
		sb.push("</TABLE>");
		this.getBodyBox().html(sb.join(""));
	}
	
	this.getRowByIndex = function(index){
		return this.rows[index];
	};
	
	this.bind=function(data){
		this.rows = [];
		for(var i=0;i<data.length;i++){
			var row = new CSST.UI.GridRow(data[i],i,this);
			this.rows.push(row);
		}
		this.paintRows();
		this.layout();
		this.currentData = data;
		
	};
	
	this.getSelectedRows = function(){
		var selected = [];
		for(var i=0;i<this.rows.length;i++){
			var row = this.rows[i];
			if(row.selected)
				selected.push(row);
		}
		return selected;
	}
	
	this.getSelectedRowsData = function(){
		var selected = this.getSelectedRows();
		var rows = [];
		for(var i=0;i<selected.length;i++){
			var data = selected[i].data;
			rows.push(data);
		}
		return rows;
	}
};

CSST.UI.GridRow = function(data,index,grid){
	this.data = data;
	this.index = index;
	this.selected = false;
	this.grid = grid;
	this.getCellValue  = function(col){
		var s = col.name;
		if(s==null)
			return null;
		
		var v = null;
		if(s.startsWith("fn:")){
			s = s.substring(3);
			var data = this.data;
			v = eval(s);
		}else{		
			v =  CSST.UI.getProperty(this.data, s);
		}
		
		return v;
	};
	
	this.getElement = function(){
		return $(this.grid.getBodyTable().find("tr").eq(this.index));
	};
	this.getRowCheckbox = function(){
		return $(this.grid.getBodyTable().find("input[type=checkbox]").eq(this.index));
	};
	
	this.setSelected = function(selected){
		if(selected==null)
			selected = !this.selected;
		this.selected = selected;
		
		if(this.selected==true){
			this.getElement().attr("class","selected");
			this.getRowCheckbox().parent('span.CheckboxWrapper').addClass("csstChecked");
			this.getRowCheckbox().attr("checked",true);
		}else{
			this.getRowCheckbox().attr("checked",false);
			this.getRowCheckbox().parent('span.CheckboxWrapper').removeClass("csstChecked");
			this.getElement().attr("class",this.index%2==1?"odd":"even");
		}	
	};
	
	
	this.paint = function(){
		var sb = [];
		var className = '';
		if(this.selected)
			className = "selected";
		else
			className = this.index%2==1?"odd":"even";
		
		sb.push("<tr");
		sb.push(" onmouseover=''");
		sb.push(" onclick='CSST.UI.GridEvents.onRowClicked(\""+this.grid.id+"\","+this.index+")'");
		sb.push(" class='"+className+"'");
		sb.push(">");
		var columns =this.grid.leafCols;
		if(grid.context.selectedMode!="S")
			sb.push('<td><span class="CheckboxWrapper"><input type="checkbox" class="csstCheckbox"></span></td>');
		for(var i=0;i<columns.length;i++){
			sb.push(this.paintCell(columns[i]));
		}
		sb.push("</tr>");		
		var r = sb.join("");
		return r;
	};
	
	this.paintCell = function(col){
		var str = this.grid.getCellRender(col).render(this.grid,this,col);
		var sb = [];
		var cellId = "cell@"+this._index+"@"+col.name;		
		var align = this.grid.getColumnAlign(col);
		var className = "";
		if(this.grid.rows.indexOf(this)==this.grid.rows.length-1)
			className = "lastRow";
		sb.push('<td id="'+cellId+'" style="text-align:'+align+';"');	
		sb.push(' class="'+className+'"');	
		sb.push(' ><div class="cellDiv">'+str+"</div>");		
		sb.push('</td>');
		var r = sb.join("");
		return r;
	}
};



CSST.UI.log = function(s){
	$("#log").text( $("#log").text() + ("\r\n" +s));
};

CSST.UI.dlgs = [];

CSST.UI.closeDlg=function(){
	setTimeout("CSST.UI.closeDlgSure()",100);
}

CSST.UI.closeDlgSure = function(){
	dlgs = window.top.CSST.UI.dlgs;
	dlgs[dlgs.length-1].close();
}

CSST.UI.openDlg = function(url,title,dlgWidth,dlgHeight,type,msg){
	var topWin = window.top;
	if(topWin!=window){
		return topWin.CSST.UI.openDlg(url,title,dlgWidth,dlgHeight,type,msg);
	}
		
	this.createContent=function(type,msg,dlgIndex){
		if(typeof(msg)=="string"){
			message = msg;
			msg = [];
			msg.push(message);
			msg.push("");
		}
		if(msg.length==1)
			msg.push("");
			
		if(type=="info" || type=="warn" || type=="error" || type=="success" || type=="confirm"){
			var sb = [];
			sb.push('<form class="jNice" id="'+type+'formId">');
			sb.push('<table class="tipTable" cellpadding="0" cellspacing="0">');
			sb.push('<tr><td  class="iconTd">');
			sb.push('<div class="bigIcon icon'+type+'"></div>');
			sb.push('</td><td class="textTd">');
			sb.push('<div class="tipTxtBig '+type+'">');
			sb.push(msg[0]);
			sb.push('</div>');
			sb.push('<div class="tipTxtSamll">');
			sb.push(msg[1]);
			sb.push('</div>');
			sb.push(' </td></tr></table>');
			sb.push('<div class="popBtnBar">');
			if(type=="confirm"){
				sb.push('<input type="button" class="csstbutton curBtn" id="okBtn_'+dlgIndex+'" value="确&nbsp;&nbsp;定" />');
				sb.push('<input type="button" class="csstbutton" id="cancelBtn_'+dlgIndex+'" value="取&nbsp;&nbsp;消" />');
			}else{
				sb.push('<input type="button" class="csstbutton" id="okBtn_'+dlgIndex+'" value="确&nbsp;&nbsp;定" />');
			}
			sb.push('</div>');
			sb.push('</form>');
			return sb.join("");
		}
	}
	
	
	var height = $(topWin.document).height();
	var width = $(topWin.document).width();
	
	var boxIndex = 1001;
	var overlayer = $("#_csstDlgOverLayer");
	if(overlayer.attr("id")==null){
		overlayer = null;
	}
	if(overlayer==null){
		overlayer = $("<div class='dlg_overlayer' id='_csstDlgOverLayer'></div>")
			.height(height-4)
			.css("z-index",1000);
		$(topWin.document.body).append(overlayer);
	}else{
		var zIndex = 1*overlayer.css("z-index")+2;
		overlayer.css("z-index",zIndex);
		boxIndex = zIndex+1;
	}
	
	var top = (height-dlgHeight)/2;
	var left = (width-dlgWidth)/2;
	
	var box = $("<div class='dlg_box' id='dlgBox_" + boxIndex + "'></div>")
		.height(dlgHeight)
		.width(dlgWidth)
		.css("left",left)
		.css("top",top)		
		.css("z-index",boxIndex);
	$(topWin.document.body).append(box);
	
	var titleBox = null;
	titleBox = $("<div class='dlg_titleBox' id='titleBox_" + boxIndex + "'></div>");
	$(box).append(titleBox);
	
	//拖动效果
	var Bind = function(object, fun) {
	    return function() {
	        return fun.apply(object, arguments);
	    }
	};

	var BindAsEventListener = function(object, fun) {
	    return function(event) {
	        return fun.call(object, (event || window.event));
	    }
	};

	var Extend = function(destination, source) {
	    for (var property in source) {
	        destination[property] = source[property];
	    }
	};
	var CurrentStyle = function(element){
	    return element.currentStyle || document.defaultView.getComputedStyle(element, null);
	};
	var isIE = (document.all) ? true : false;
	
	var Class = {
		    create: function() {
		        return function() { this.initialize.apply(this, arguments); }
		    }
	};
	
	var $Id = function (id) {
	    return "string" == typeof id ? document.getElementById(id) : id;
	};
	var CSST_UI_draggable = Class.create();
	
	function addEventHandler(oTarget, sEventType, fnHandler) {
	    if (oTarget.addEventListener) {
	        oTarget.addEventListener(sEventType, fnHandler, false);
	    } else if (oTarget.attachEvent) {
	        oTarget.attachEvent("on" + sEventType, fnHandler);
	    } else {
	        oTarget["on" + sEventType] = fnHandler;
	    }
	};

	function removeEventHandler(oTarget, sEventType, fnHandler) {
		if (oTarget.removeEventListener) {
		oTarget.removeEventListener(sEventType, fnHandler, false);
		} else if (oTarget.detachEvent) {
		oTarget.detachEvent("on" + sEventType, fnHandler);
		} else {
		oTarget["on" + sEventType] = null;
		}
	};
	
	CSST_UI_draggable.prototype = {
			//拖放对象
			initialize: function(drag, options) {
			    this.Drag = $Id(drag);//拖放对象
			    this._x = this._y = 0;//记录鼠标相对拖放对象的位置
			    this._marginLeft = this._marginTop = 0;//记录margin
			    //事件对象(用于绑定移除事件)
			    this._fM = BindAsEventListener(this, this.Move);
			    this._fS = Bind(this, this.Stop);
			    
			    this.SetOptions(options);
			    
			    this.Limit = !!this.options.Limit;
			    this.mxLeft = parseInt(this.options.mxLeft);
			    this.mxRight = parseInt(this.options.mxRight);
			    this.mxTop = parseInt(this.options.mxTop);
			    this.mxBottom = parseInt(this.options.mxBottom);
			    
			    this.LockX = !!this.options.LockX;
			    this.LockY = !!this.options.LockY;
			    this.Lock = !!this.options.Lock;
			    
			    this.onStart = this.options.onStart;
			    this.onMove = this.options.onMove;
			    this.onStop = this.options.onStop;
			    
			    this._Handle = $Id(this.options.Handle) || this.Drag;
			    this._mxContainer = $Id(this.options.mxContainer) || null;
			    
			    this.Drag.style.position = "absolute";
			    //透明
			    if(isIE && !!this.options.Transparent){
			        //ie6渲染bug
			        this._Handle.style.overflow = "hidden";
			        //填充拖放对象
			        with(this._Handle.appendChild(document.createElement("div")).style){
			            width = height = "100%"; backgroundColor = "#fff"; filter = "alpha(opacity:0)";
			        }
			    }
			    //修正范围
			    this.Repair();
			    addEventHandler(this._Handle, "mousedown", BindAsEventListener(this, this.Start));
			},
			//设置默认属性
			SetOptions: function(options) {
			    this.options = {//默认值
			        Handle:            "",//设置触发对象（不设置则使用拖放对象）
			        Limit:            false,//是否设置范围限制(为true时下面参数有用,可以是负数)
			        mxLeft:            0,//左边限制
			        mxRight:        $(topWin.document).width(),//右边限制
			        mxTop:            0,//上边限制
			        mxBottom:       $(topWin.document).height(),//下边限制
			        mxContainer:    "",//指定限制在容器内
			        LockX:            false,//是否锁定水平方向拖放
			        LockY:            false,//是否锁定垂直方向拖放
			        Lock:            false,//是否锁定
			        Transparent:    false,//是否透明
			        onStart:        function(){},//开始移动时执行
			        onMove:            function(){},//移动时执行
			        onStop:            function(){}//结束移动时执行
			    };
			    Extend(this.options, options || {});
			},
			//准备拖动
			Start: function(oEvent) {
			    if(this.Lock){ return; }
			    this.Repair();
			    //记录鼠标相对拖放对象的位置
			    this._x = oEvent.clientX - this.Drag.offsetLeft;
			    this._y = oEvent.clientY - this.Drag.offsetTop;
			    //记录margin
			    this._marginLeft = parseInt(CurrentStyle(this.Drag).marginLeft) || 0;
			    this._marginTop = parseInt(CurrentStyle(this.Drag).marginTop) || 0;
			    //mousemove时移动 mouseup时停止
			    addEventHandler(document, "mousemove", this._fM);
			    addEventHandler(document, "mouseup", this._fS);
			    if(isIE){
			        //焦点丢失
			        addEventHandler(this._Handle, "losecapture", this._fS);
			        //设置鼠标捕获
			        this._Handle.setCapture();
			    }else{
			        //焦点丢失
			        addEventHandler(window, "blur", this._fS);
			        //阻止默认动作
			        oEvent.preventDefault();
			    };
			    //附加程序
			    this.onStart();
			},
			//修正范围
			Repair: function() {
			    if(this.Limit){
			        //修正错误范围参数
			        this.mxRight = Math.max(this.mxRight, this.mxLeft + this.Drag.offsetWidth);
			        this.mxBottom = Math.max(this.mxBottom, this.mxTop + this.Drag.offsetHeight);
			        //如果有容器必须设置position为relative来相对定位，并在获取offset之前设置
			        !this._mxContainer || CurrentStyle(this._mxContainer).position == "relative" || (this._mxContainer.style.position = "relative");
			    }
			},
			//拖动
			Move: function(oEvent) {
			    //判断是否锁定
			    if(this.Lock){ this.Stop(); return; };
			    //清除选择
			    window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
			    //设置移动参数
			    var iLeft = oEvent.clientX - this._x, iTop = oEvent.clientY - this._y;
			    //设置范围限制
			    if(this.Limit){
			        //设置范围参数
			        var mxLeft = this.mxLeft, mxRight = this.mxRight, mxTop = this.mxTop, mxBottom = this.mxBottom;
			        //如果设置了容器，再修正范围参数
			        if(!!this._mxContainer){
			            mxLeft = Math.max(mxLeft, 0);
			            mxTop = Math.max(mxTop, 0);
			            mxRight = Math.min(mxRight, this._mxContainer.clientWidth);
			            mxBottom = Math.min(mxBottom, this._mxContainer.clientHeight);
			        };
			        //修正移动参数
			        iLeft = Math.max(Math.min(iLeft, mxRight - this.Drag.offsetWidth), mxLeft);
			        iTop = Math.max(Math.min(iTop, mxBottom - this.Drag.offsetHeight), mxTop);
			    }
			    //设置位置，并修正margin
			    if(!this.LockX){ this.Drag.style.left = iLeft - this._marginLeft + "px"; }
			    if(!this.LockY){ this.Drag.style.top = iTop - this._marginTop + "px"; }
			    //附加程序
			    this.onMove();
			},
			//停止拖动
			Stop: function() {
			    //移除事件
			    removeEventHandler(document, "mousemove", this._fM);
			    removeEventHandler(document, "mouseup", this._fS);
			    if(isIE){
			        removeEventHandler(this._Handle, "losecapture", this._fS);
			        this._Handle.releaseCapture();
			    }else{
			        removeEventHandler(window, "blur", this._fS);
			    };
			    //附加程序
			    this.onStop();
			}
		};
	var dragHandler= new CSST_UI_draggable('dlgBox_' + boxIndex, {Handle: 'titleBox_' + boxIndex , Limit: true});
	
	var northWest = null;
	northWest = $("<div class='dlgNW' id='dlgNW_" + boxIndex + "'></div>");
	$(titleBox).append(northWest);
	
	var northEast = null;
	northEast = $("<div class='dlgNE' id='dlgNE_" + boxIndex + "'></div>");
	$(titleBox).append(northEast);
	
	var north = null;
	north = $("<div class='dlgN' id='dlgN_" + boxIndex + "'></div>");
	$(titleBox).append(north);
	
	var dlgTitle =null;
	dlgTitle =  $("<div class='dlg_title' id='dlgTitle_" + boxIndex + "'></div>").html(title);
	$(north).append(dlgTitle);
	
	var dlgButtons = null;
	dlgButtons = $("<div class='dlg_buttons' id='dltButtons_" + boxIndex + "'></div>");
	$(north).append(dlgButtons);
	//	a$(dlgButtons).css("z-index",boxIndex+1);
	var closeBtn = null;
	closeBtn = $("<a href='#' class='dlg_closeBtn icon iconDlgCloseLeave' id='closeBtn_" + boxIndex + "'></a>");
	$(dlgButtons).append(closeBtn);
	$("#closeBtn_" + boxIndex).hover(function(){$(this).removeClass("iconDlgCloseLeave");$(this).addClass("iconDlgCloseIn")},function(){$(this).removeClass("iconDlgCloseIn");$(this).addClass("iconDlgCloseLeave")});

	
	
	var dlgMiddleBox = $("<div class='dlgMiddleBox' id='dlgMiddleBox_" + boxIndex + "'></div>");
	$(box).append(dlgMiddleBox);
	
	var west = null;
	west = $("<div class='dlgW' id='dlgW_" + boxIndex + "'></div>");
	dlgMiddleBox.append(west);
	var east = null;
	east = $("<div class='dlgE' id='dlgE_" + boxIndex + "'></div>");
	$(dlgMiddleBox).append(east);
	
	var contentBox = null;
	var sb = [];
	sb.push("<div class='dlg_ContentBox' id='contentBox_");
	sb.push(boxIndex);
	sb.push("'>");
	if(url!=null && url.length>0){
		sb.push("<iframe class='dlgFrame' id='dlgFrame_");
		sb.push(boxIndex);
		sb.push("'frameborder='0'  allowTransparency='true' src='");
		sb.push(url);
		sb.push("'></iframe>");
	}else{
		sb.push(this.createContent(type,msg,boxIndex));
	}
	sb.push("</div>");
	contentBox = $(sb.join(""));
	
	$(dlgMiddleBox).append(contentBox);
	
	var bottomBox = $("<div class='bottomBox' id='bottomBox_" + boxIndex + "'></div>");
	$(box).append(bottomBox);
	var westSourth = null;//titlebar上的title和buttons;
	westSourth = $("<div class='dlgWS' id='dlgWS_" + boxIndex + "'></div>");
	$(bottomBox).append(westSourth);
	var eastSourth = null;//titlebar上的title和buttons;
	eastSourth = $("<div class='dlgES' id='dlgES_" + boxIndex + "'></div>");
	$(bottomBox).append(eastSourth);
	var sourth = null;//titlebar上的title和buttons;
	sourth = $("<div class='dlgS' id='dlgS_" + boxIndex + "'></div>");
	$(bottomBox).append(sourth);

	var middleHeight =  dlgHeight-titleBox.height()-bottomBox.height() ;
	dlgMiddleBox.height(middleHeight);
	contentBox.height(middleHeight);
	
	var dlgHandler = {};
	dlgHandler.id = boxIndex;	
	dlgHandler.type = type;
	dlgHandler.onClose = function(result){};
	dlgHandler.close = function(){
		//关闭对话框中弹出的其他层
		if(this.type==null && window.currentPosPicker!=null)
			window.currentPosPicker.cancelMap();
		
		var dlgs = window.top.CSST.UI.dlgs;
		dlgs.removeAt(dlgs.length-1);
		var iframe = window.top.document.getElementById("dlgFrame_"+this.id);
		if(iframe!=null){
			iframe.src="about:blank";
			try{  
	            iframe.contentWindow.document.write('');  
	            iframe.contentWindow.document.clear();
	            iframe.removeNode(true);
	            CollectGarbage();
	        }catch(e){};  
	        iframe = null;
		}
		
		$("#dlgBox_" + this.id).remove(); 
		if(this.id > 1001 ){
			$('#_csstDlgOverLayer').css("z-index", $('#_csstDlgOverLayer').css("z-index")-2);
			
		}else{					
			$('#_csstDlgOverLayer').remove();				
		}
		if(this.type==null)
			this.returnValue = window.top._returnValue;
		window.top._returnValue = null;
		
		this.onClose(this.returnValue);
	}
	
	// 右上角关闭事件
	$("#closeBtn_" + boxIndex).click( 
		function(){ 
			dlgHandler.returnValue = false;
			dlgHandler.close();
		}
	);
	
	if($('form.jNice').length>0)
		$('form.jNice').jNice();	
	
	$("#okBtn_" + boxIndex).click( 
		function(){ 
			dlgHandler.returnValue = true;
			dlgHandler.close();
		}
	);
	
	$("#cancelBtn_" + boxIndex).click( 
		function(){ 
			dlgHandler.returnValue = false;
			dlgHandler.close();
		}
	);
	CSST.UI.dlgs.push(dlgHandler);
	return dlgHandler;
}

CSST.UI.showMsg = function(type,msg,width,height){
	var url = null;
	var title = "";
	if(type=="info")
	 	title = "提示";
	else if (type=="warn"){
		title = "警告";
	}else if(type=="error"){
		title = "错误";
	}else if(type=="success"){
		title = "正确";
	}else if(type=="confirm"){
		title = "提醒";
	}
	
	if(width == null){
		width = 350;
	}
	if(height == null){
		height = 210;
	}
	
	var dlgHandler = this.openDlg(url,title,width,height,type,msg);
	return dlgHandler;
}

CSST.UI.confirm = function(msg,width,height){
	return this.showMsg("confirm",msg,width,height);
}

/**
 * 创建tabs容器
 * @param divId
 * @param width
 * @param height
 */
CSST.UI.Tabs =function(divId,width,height){
	this.boxId = divId;
	this.width = width ;
	this.height = height;
	this.focusedId = null;
	function tab_Click(_this,boxId,tabId){
		  $("#title_"+tabId).click(function(){
			  $("#titleList_"+boxId+">li").removeClass("current");
			  $("#title_"+tabId).addClass("current");
			  $("#content_"+boxId+">div").attr("class","divtab");
			  $("#"+tabId).attr("class","divtab_current");
			  _this.focusedId = tabId;
		  });
	 }

	$("#"+divId).append("<ul class='CSST_UI_tabTop' id=titleList_"+divId+"></ul><div class='CSST_UI_tabContent' id=content_"+divId+"></div>");
	$("#"+divId).css("width",width-2);
	$("#content_"+divId).css({width: width, height: height}); 
	
	this.addTab=function(title,tabDiv,focused){
		tabDiv.css("display","");
		var titleId = "title_"+tabDiv.attr("id");
		var tabId = tabDiv.attr("id");
		$("#titleList_"+this.boxId).append("<li id="+titleId+"><a href='javascript:void(0);'><span></span>"+title+"</a></li>");
		$("#content_"+this.boxId).append(tabDiv);
		tabDiv.addClass("divtab");
		$(".divtab").css({width: this.width-12, height:this.height-12});
		tab_Click(this,this.boxId,tabId);		
		if(focused){
			$("#"+titleId).addClass("current");
			$("#"+tabId).removeClass("divtab");
			$("#"+tabId).addClass("divtab_current");
			this.focusedId = tabId;
		}
		if($('.CSST_UI_tabContent .toolBar').length>0)
			$('.CSST_UI_tabContent .toolBar').width(this.width-12);
	};
	/*	 function tab_Mouseover(tabid){//移过
			  $("#"+tabid).mouseover(function(){
										  $("#"+tabId+">li").removeClass("current");
										  $("#"+tabid).addClass("current");
										  $("#content"+tabId+">div").removeClass("divtab_current");
										  $("#content"+tabId+">div").addClass("divtab");
										  $("#content"+tabid).removeClass("divtab");
										  $("#content"+tabid).addClass("divtab_current");
										  })
	} */
	
	 //获取当前被选中的tab page id	 
	 this.getFocusedId = function (){
		 return this.focusedId;
	 }; 
};



CSST.UI.posPickerFn = {
	loadMapScript:function(){
		var topwin = window.top;
		var script = topwin.document.createElement("script");
		script.src = "http://api.map.baidu.com/api?v=1.2&callback=CSST.UI.posPickerFn.initMap";	
		topwin.document.body.appendChild(script);
	},
	createMapDiv:function(){
		var topwin = window.top;
		var dd ="<div id='mapContainer' class='mapDiv'></div><div class='mapBtn'><input type='button'  value='确&nbsp;定' id='getMapInfo'   /><input type='reset'  id='cancelMap' value='取&nbsp;消'  /></div><span class='mapResizePic' id='mapResize'  ></span>";
		var mapDiv=topwin.document.createElement("div");
		mapDiv.innerHTML = dd;
		mapDiv.className = "mapBox";
		mapDiv.id = "mapBox";
		$(topwin.document.body).append(mapDiv);
		mapDiv.style.display = "block";
		mapDiv.style.left = "0";
		mapDiv.style.top = "0";
		

		
		if(window.top!=window){
			if(window.top.document.getElementById("_csstDlgOverLayer")!=null){
				var zIndex = window.top.document.getElementById("_csstDlgOverLayer").style.zIndex;
				mapDiv.style.zIndex =(1*zIndex)+1;
			}else{
				mapDiv.style.zIndex = 999;
			}
		}
	},
	initMap:function(){
		var map = new BMap.Map('mapContainer');
		var point = new BMap.Point(120.2, 30.3);  
		map.centerAndZoom(point, 11);
		var opts = {type: BMAP_NAVIGATION_CONTROL_SMALL};
		map.addControl(new BMap.NavigationControl(opts)); 
		map.addControl(new BMap.OverviewMapControl());  
		map.setCurrentCity("杭州市"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用 
		var i = 1;
		var newLng = point.lng;
		var newLat = point.lat;
		var circle;
		var infoWinOpt = {
				  width : 250,     // 信息窗口宽度
				  height: 100,     // 信息窗口高度
				  title : "请输入半径(米)："  // 信息窗口标题
				}
		var rBlock = "<div class='rBlock'><div class='rInfo'><input class='rInput' id='rInput' type='text'/></div><div class='rBtn'><input type='button' value='确定' id='getCirlInfo'/><input id='cancelCirlInfo' type='button' value='取消'/></div></div>";
		var infoWindow = new BMap.InfoWindow(rBlock,infoWinOpt);  // 创建信息窗口对象
		map.addEventListener("click", function(e){ 
			map.clearOverlays();
			var marker = new BMap.Marker(e.point);        // 创建标注  
			map.addOverlay(marker);                     // 将标注添加到地图中
			if(window.top.document.getElementById("_csstDlgOverLayer")!=null){
				window.top.currentPosPicker.position = e.point;
			}
			else{
				window.top.currentPosPicker.position = e.point;
				map.removeOverlay(circle);
				point=e.point;
				marker.setPosition(point);
				marker.openInfoWindow(infoWindow);
				$("#getCirlInfo").bind("click",function(){
					map.clearOverlays();
					map.addOverlay(marker);
					var r  = $("#rInput").attr("value");
					window.top.currentPosPicker.r_circle = r;
					circle = new BMap.Circle(point,r,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
					map.addOverlay(circle);
				})
				$("#cancelCirlInfo").bind("click",function(){
					map.clearOverlays();
					map.closeInfoWindow();
				})
			}
			return false;			
		}); 
	}	
}

CSST.UI.posPicker=function(obj){
	var topwin=window.top;
	if(topwin.document.getElementById("mapBox")!=null){
		return ;
	}
	$(obj).bind("click",function(){
		CSST.UI.posPicker(this);
	})
	
	var handler={};
	topwin.currentPosPicker = handler;
	handler.input = obj;	
	handler.cancelMap=function(){
		$(topwin.document.getElementById("mapBox")).remove();
		obj.blur();
		topwin.currentPosPicker = null;
		return false;
	}
	handler.showInfo = function(){
		if(window.top.document.getElementById("_csstDlgOverLayer")!=null){
			if( topwin.currentPosPicker.position == null){
				var dlg = CSST.UI.showMsg("warn",["请标记坐标点？","点击地图"],350,210);
				return false;
			}
			this.input.value = topwin.currentPosPicker.position.lng+","+topwin.currentPosPicker.position.lat;
			$(topwin.document.getElementById("mapBox")).remove();	
		}else{
			this.input.value = topwin.currentPosPicker.position.lng+","+topwin.currentPosPicker.position.lat+","+topwin.currentPosPicker.r_circle;
			$(topwin.document.getElementById("mapBox")).remove();	
		}
		return false;
	}
	
	this.oInput = obj;
	CSST.UI.posPickerFn.createMapDiv();
	CSST.UI.posPickerFn.loadMapScript();
	
	
	var mapBox = $(topwin.document.body).find('#mapBox');
	var height = $(topwin.document).height();
	var width = $(topwin.document).width();
	var relativeX = $(obj).offset().left;  
	var relativeY = $(obj).offset().top+$(obj).height();
	
	var xd = "right";
	var yd = "bottom";
	
	var x = 0;
	var y = 0;
	
	
	if(topwin!=window){
		var parentDlg =	$(topwin.document.body).find(".dlg_box")[0];	
		if(parentDlg!=null){
			var dlgWidth =$(parentDlg).offset().left;
			var dlgHeight =$(parentDlg).offset().top;
			x=dlgWidth+relativeX+5;
			y=dlgHeight+relativeY+36;
		}else{
			x=relativeX;
			y=relativeY+62;
		}
		
	}else{		
		x=relativeX;
		y=relativeY;
	};
	
	if(x+mapBox.width()>width){
		x = x - mapBox.width();
	}
	if(y+mapBox.height()>height){
		y = y - mapBox.height()-$(obj).height();
	}
	mapBox.css("left",x);
	mapBox.css("top",y);
	
	
	
	$(topwin.document.body).find('#cancelMap').click(function(){ 
		window.top.currentPosPicker.cancelMap();
	});
	$(topwin.document.body).find('#getMapInfo').click(function(){ 
		window.top.currentPosPicker.showInfo();
	});
	//mapBox的resize实现
	
	var resizing = false;
	
	$(document).mouseup(function(e) {
        resizing = false;
    });
	var mapContainer = $(topwin.document.body).find('#mapContainer');
	var mapResizeObj = $(topwin.document.body).find('#mapResize');
	mapResizeObj.mousedown(function(e) {
        e.preventDefault();
        resizing = true;
    });
	
	mapResizeObj.mousemove(function(e) {
	    if(resizing) {
	      var origHeightBox= mapBox.height();
		  var origWidthBox = mapBox.width();
		  
		  
	      var origResizeYGrip = mapResizeObj.offset().top;
		  var origResizeXGrip = mapResizeObj.offset().left;
		
		  var resizeHeight =mapResizeObj.height();
		  var resizeWidth = mapResizeObj.width();
		  /***
		  if(mapBox.height()>285 && mapBox.width()<= 300){
			  mapBox.height(e.pageY - origResizeYGrip + origHeightBox - resizeHeight/2);
			  mapBox.width(300);
			  mapContainer.height(mapBox.height()-35);
			  mapContainer.width(300);
		  }
		  else if(mapBox.height()<=285 && mapBox.width()> 300 ){
			  mapBox.height(285);
			  mapBox.width(e.pageX - origResizeXGrip + origWidthBox - resizeWidth/2);
			  mapContainer.height(250);
			  mapContainer.width(mapBox.width());
		  }
		  else{
		  }****/
			  mapBox.height(e.pageY - origResizeYGrip + origHeightBox - resizeHeight/2);
			  mapBox.width(e.pageX - origResizeXGrip + origWidthBox - resizeWidth/2);
			  mapContainer.height(mapBox.height()-35);
			  mapContainer.width(mapBox.width());
		  
		 }
	 });
	
	
	mapBox.bind("click",function(e){return false});
	
	$(document.body).bind("click",function(e){	
	     resizing = true;
		if($(e.target).is(mapBox) || $(e.target).is($(obj))){
		}
		else{
			topwin.currentPosPicker.cancelMap();
		}
		return false;
	});
	
	$(topwin.document.body).bind("click",function(e){	
	     resizing = true;
		if($(e.target).is(mapBox) || $(e.target).is($(obj))){
		}
		else{
			topwin.currentPosPicker.cancelMap();
		}
		return false;
	});
	
	return false;
}


/**
 * 纯文本输入
 * @param jqInput
 */
CSST.UI.TextInput = function(jqInput){
	this.setReadonly = function(b){
		jqInput[0].readOnly = b;
		if(b==true)
			jqInput.parent().parent().attr("class", "inputWrap2");
		else
			jqInput.parent().parent().attr("class", "inputWrap");
	}
	this.getName = function(){
		return jqInput.attr("name");
	}
	this.getValue = function(){
		return jqInput.attr("value");
	}
	this.setValue = function(obj){
		var v = CSST.UI.getProperty(obj,jqInput.attr("name"));
		if(v==null)
			v = "";
		jqInput.attr("value",v);
	}
}
CSST.UI.PosInput = function(jqInput){
	this.setReadonly = function(b){
		jqInput[0].readOnly = b;
		if(b==true)
			jqInput.parent().parent().attr("class", "inputWrap2");
		else
			jqInput.parent().parent().attr("class", "inputWrap");
	}

	this.getName = function(){
		return jqInput.attr("name");
	}
	this.getValue = function(){
		var s = jqInput.attr("value");	
		if(s=="")
			return "";
		/***
		var ss = s.split(";");
		var value = {};
		value.longitude = ss[0];
		value.latitude = ss[1];
		return value;	
		***/
		var value;
		value = s;
		return value;
	}
	this.setValue = function(obj){
		var v = CSST.UI.getProperty(obj,jqInput.attr("name"));
		if(v==null)			
			jqInput.attr("value","");
		else
			jqInput.attr("value",v);
	}
}
CSST.UI.CalendarInput = function(jqInput){
	this.setReadonly = function(b){
		jqInput[0].readOnly = b;
		if(b==true)
			jqInput.parent().parent().attr("class", "inputWrap2");
		else
			jqInput.parent().parent().attr("class", "inputWrap");
	}
	this.getName = function(){
		return jqInput.attr("name");
	}
	this.getValue = function(){
		var s = jqInput.attr("value");	
		if(s==null || s=="")
			return null;
		return s.toDate().getTime();
	}

	this.setValue = function(obj){
		var value = CSST.UI.getProperty(obj,jqInput.attr("name"));
		var vDate = new Date();
		if(value!=null )
			vDate = new Date(value);
		var s = vDate.toStr();
		var length = jqInput.attr("maxlength");
		if(length!=null)
			s = s.substring(0, 1*jqInput.attr("maxlength"));
		jqInput.attr("value",s);
	}
}

CSST.UI.TimeInput = function(jqInput,form){
	this.name = jqInput.attr("name");
	this.form = form;
	this.setReadonly = function(b){
		jqInput[0].readOnly = b;
		if(b==true)
			jqInput.parent().parent().attr("class", "inputWrap2");
		else
			jqInput.parent().parent().attr("class", "inputWrap");
	}
	this.getName = function(){
		return this.name;
	}
	this.getElements = function(){
		var all = jqInput.parent().find("span > input");
		return all;
	}
	this.getValue = function(){
		var elements = this.getElements();
		var h = elements[0].value;
		var m = elements[1].value;
		var s = elements[2].value;
		return s*1+m*60+h*3600;
	}
	this.setValue = function(obj){
		var value = CSST.UI.getProperty(obj, jqInput.attr("name"));
		if(value==null)
			value = 0;
		else
			value = 1*value;
		var s = value % 60;
		var m = (value % 3600-s)/60;
		var h = (value-m*60-s) / 3600;
		var elements = this.getElements();
		elements[0].value = h;
		elements[1].value = m;
		elements[2].value = s;
	}
	
	this.increase = function(type){
		var offset = 0;
		if(type=="h")
			offset = 3600;
		else if(type=="m")
			offset = 60;
		else if(type=="s")
			offset = 1;
		this.add(offset);
	}
	
	this.reduce = function(type){
		var offset = 0;
		if(type=="h")
			offset = 3600;
		else if(type=="m")
			offset = 60;
		else if(type=="s")
			offset = 1;
		this.add(0-offset);
	}
	
	/*
	* 以秒为单位增加或者减少一定的时长
	*/
	
	this.add = function(offset){
		var v = this.getValue();
		v = v + offset;
		if(v < 0)
			return false;
		var obj = {};
		CSST.UI.setProperty(obj,jqInput.attr("name"), v);
		this.setValue(obj);
	}
}

CSST.UI.CheckInput = function(jqInput,form){
	this.name = jqInput.attr("name");
	this.form = form;
	this.getName = function(){
		return this.name;
	}
	this.getElements = function(){
		return this.form.getJQForm().find("input[type=checkbox][name*="+this.name+"]");
	}
	this.getValue = function(){
		var v = [];
		var elements = this.getElements();
		for(var i=0;i<elements.length;i++){
			if(elements[i].checked){
				v.push(elements[i].value);
			}
		}
		return v;
	}
	this.setValue = function(obj){
		var v = CSST.UI.getProperty(obj,this.name);
		if(v instanceof Array){
			var elements = this.getElements();
			for(var i=0;i<elements.length;i++){
				if(v.contains(elements[i].value)){
					elements[i].checked=true;
					$(elements[i]).parent('span.CheckboxWrapper').addClass('csstChecked');	
				}else{
					elements[i].checked=false;
					$(elements[i]).parent('span.CheckboxWrapper').removeClass('csstChecked');	
				}
			}
		}
	}
	this.getElements().each(function(){
		$(this).addClass('csstCheckbox').wrap('<span class="CheckboxWrapper"></span>');
		$(this).bind("click",function(){
			var v = {};
			v[this.name] = form.editors[this.name].getValue();
			form.editors[this.name].setValue(v);
		});
	});
}

CSST.UI.RadioInput = function(jqInput,form){
	this.name = jqInput.attr("name");
	this.form = form;
	this.getName = function(){
		return this.name;
	}
	this.getElements = function(){
		return this.form.getJQForm().find("input[type=radio][name*="+this.name+"]");
	}
	this.getValue = function(){
		var elements = this.getElements();
		for(var i=0;i<elements.length;i++){
			if(elements[i].checked == true){
				return elements[i].value;
			}
		}
	}
	this.setValue = function(obj){
		var v = ""+CSST.UI.getProperty(obj,this.name);
		var elements = this.getElements();
		for(var i=0;i<elements.length;i++){
			if(elements[i].value == v){
				elements[i].checked = true;
				$(elements[i]).parent().addClass("csstRadioChecked")
			}else{
				$(elements[i]).parent().removeClass("csstRadioChecked")
			}
		}
	}
	this.getElements().each(function(){
		$(this).addClass('csstRadio').wrap('<span class="RadioWrapper"></span>');
		$(this).bind("click",function(){
			var v = {};
			v[this.name] = this.value;
			form.editors[this.name].setValue(v);
		});
	});
}

CSST.UI.indexOfSelectInput = 0;
CSST.UI.Multiple_selInput = function(jqInput,form){
	this.name = jqInput.attr("name");
	this.form = form;
	this.getName = function(){
		return this.name;
	}
	this.getValue = function(){
		var value = [];
		$('option',jqInput).each(function(index){
			var $this = $(this);
			if(this.selected == true){
				value.push(this.value);
			}
		});
		return value;
	}
	this.getSelectedOptions = function(){
		var options = [];
		$('option',jqInput).each(function(index){
			if(this.selected == true){
				var option = {};
				option.name = this.text;
				option.value = this.value;
				options.push(option);
			}
		});
		return options;
	}
	
	this.getOptions = function(){
		var options = [];
		$('option',jqInput).each(function(index){
				var option = {};
				option.name = this.text;
				option.value = this.value;
				options.push(option);
		});
		return options;
	}
	
	this.removeOptions = function(options){
		var values = [];
		for(var i=0;i<options.length;i++){
			values.push(options[i].value);
		}
		$('option',jqInput).each(function(index){
			if(values.contains(this.value)){
				this.parentNode.removeChild(this);
			}
		});
		this.repaintLi();
	}
	
	this.addOptions = function(options){
		for(var i=0;i<options.length;i++){
			jqInput[0].options.add(new Option(options[i].name,options[i].value));	
		}
		this.repaintLi();
	}
	
	this.repaintLi = function(){
		var $ul = jqInput.parent().parent().parent().find("ul.wrapperList");
		$ul.empty();
		$('option',jqInput[0]).each(function(i){
			$ul.append('<li><a href="javascript:void(0);" index="'+ i +'">'+ this.text +'</a></li>');
		});	
		
		$ul.find('a').click(function(){			
			form.editors[jqInput.attr("name")].setOptionSelected(1*$(this).attr("index"));			
		});		
		
	}
	this.repaint = function(){
		var $ul = jqInput.parent().parent().parent().find("ul.wrapperList");
		var $select = $ul.parent().find("select.csstSelect"); 
		var options = $select[0].options;
		$ul.find('a.selected').removeClass('selected');	
		for(var i=0;i<options.length;i++){
			if(options[i].selected == true){
				$($ul.find('a')[i]).addClass('selected');
			}
		}
	}
	
	this.setOptionSelected = function(index){
		var option = jqInput[0].options[index];
		option.selected = !option.selected;
		this.repaint();
	}
	
	this.isOptionSelected = function(index){
		return jqInput[0].options[index].selected;
	}
	
	
	this.setValue = function(obj){
		var v = CSST.UI.getProperty(obj,jqInput.attr("name"));	
		if(v == null||v==undefined){return}
		$('option',jqInput[0]).each(function(index){
			var $this = $(this);
			if(v.contains($this.attr("value"))){
				this.selected = true;		
			}
		})
		this.repaint();
	};
	
	jqInput.each(function(){
		var size = jqInput.attr("size")*1;
		var dd=[];
		dd.push('<span class="selectMulWrapper">');
		dd.push('<div class="wrapperTopLeft"><div class="wrapperTopRight"></div></div>');
		dd.push('<ul class="wrapperList"></ul>');
		dd.push('<div class="wrapperBtmLeft"><div class="wrapperBtmRight"></div></div>');
		dd.push('</span>');
		var selectedHtml = dd.join('');
		$(this).addClass('csstSelect').wrap(selectedHtml);
		$(this).parent().parent().parent().width(149);
		var $ul  =$(this).parent().parent().parent().children('ul.wrapperList');
		$ul.width(147);
		$ul.height(size*28);
		$('option',this).each(function(i){
			$ul.append('<li><a href="javascript:void(0);" index="'+ i +'">'+ this.text +'</a></li>');
		});	
		
		$ul.find('a').click(function(){			
			form.editors[jqInput.attr("name")].setOptionSelected(1*$(this).attr("index"));			
		});		
	});
}

CSST.UI.Single_selInput = function(jqInput,form){
	this.name = jqInput.attr("name");
	this.form = form;
	
	this.getName = function(){
		return this.name;
	}
	this.getValue = function(){
		var value = null;
		$('option',jqInput).each(function(index){
			var $this = $(this);
			if(this.selected == true){
				value = this.value;
			}
		});
		return value;
		
	}
	
	this.repaint = function(){
		var $ul = jqInput.parent().find("ul.selectGroup");
		$ul.find('a.selected').removeClass('selected');	
		var option = jqInput[0].options[jqInput[0].selectedIndex];
		$($ul.find('a')[jqInput[0].selectedIndex]).addClass('selected');
		$ul.parent().children("input.inputTextWrap").attr("value",option.text);
	}
	
	this.setSelectedIndex = function(nIndex){
		$('option',jqInput[0]).each(function(index){
			if(index==nIndex)
				this.selected = true;
			else
				this.selected = false;
		});
		this.repaint();
	}
	
	this.setValue = function(obj){
		$('option',jqInput[0]).each(function(index){
			var $this = $(this);
			var v = CSST.UI.getProperty(obj,jqInput.attr("name"));
			if($this.attr("value") == v||(v==undefined && $this.attr("value").trim()=="")){
				this.selected = true;
			}else
				this.selected = false;
		})
		this.repaint();
	};
	
	this.expend = function(){
		var $ul = jqInput.parent().find('ul.selectGroup');
		var h = 22*$ul[0].childNodes.length+2;
		
		if(h>200)
			h=200;
		$ul.height(h);
		$ul.css('display','block');
	}

	jqInput.each(function(){
		CSST.UI.indexOfSelectInput++;
		$(this).addClass('csstSelect').wrap('<span class="inputWrap"><span class="inputWrapInner"></span></span>');
		$('<input class="inputTextWrap" /><span class="inputTypeIcon icon_selectArrow"></span><ul class="selectGroup"></ul>').insertAfter($(this));
		$(this).parent().parent('.inputWrap').css('z-index',100-CSST.UI.indexOfSelectInput);//修复IE6,IE7下面前面一个下拉层会被后面一个select框遮盖；
		var $ul  =$(this).parent().children('ul.selectGroup');
		var $input = $(this).parent().children('input.inputTextWrap');
		$input.attr('readonly','readonly');
		$('option',this).each(function(i){
			$ul.append('<li><a href="javascript:void(0);" index="'+ i +'">'+ this.text +'</a></li>');
		});		
		$(this).parent().children('input').width(125);
		var oWidth = $(this).parent().children('input').width()-4;
		$(this).parent().children('input').width(oWidth);
		$ul.width(oWidth+26);
		$(this).parent().children('span.inputTypeIcon').hover(
			function(){
				$(this).addClass('icon_selectArrowCur');
				$(this).parent().parent('span.inputWrap').addClass('inputWrap_hover');
			},function(){
				$(this).removeClass('icon_selectArrowCur');
				$(this).parent().parent('span.inputWrap').removeClass('inputWrap_hover');
			});
		$input.hover(
			function(){
				$(this).parent().children('span.inputTypeIcon').addClass('icon_selectArrowCur');
				$(this).parent().parent('span.inputWrap').addClass('inputWrap_hover');
			},function(){
				$(this).parent().children('span.inputTypeIcon').removeClass('icon_selectArrowCur');
				$(this).parent().parent('span.inputWrap').removeClass('inputWrap_hover');
		});	
		$(this).parent().children('span.inputTypeIcon').click(function(){form.editors[jqInput.attr("name")].expend();});
		$input.bind("click",function(){form.editors[jqInput.attr("name")].expend();});

		$ul.find('a').click(function(){
			form.editors[jqInput.attr("name")].setSelectedIndex(1*$(this).attr("index"));
			$ul.css("display","none");
		});
		
		var checkExternalClick = function(event) {
			if(event.target==$ul[0])
				return ;
			if ($(event.target).parents('ul.selectGroup').length == 0) { $ul.hide(); }
		};
		
		$(document).mousedown(checkExternalClick);
			
	});
}

CSST.UI.Form = function(formId){
	this.formId = formId;
	this.editors = {};
	this.value = null;
	var editors = this.editors;
	var thisForm = this;
	var $form = $('#'+formId);
	var radioName=[];
	this.originValue = {};
	
	$form.bind("reset",function(event){
		thisForm.validator.resetForm();
		thisForm.reset();
		event.preventDefault();
	});
	
	this.validator = $.validator;
	this.validator.addMethod("RegValidator", function(value,element,param) {
		if(value=="")
			return true;
		var reg = new RegExp(param,"gi");
		return reg.test(value);
	});
	this.validate = function(config){
		this.validator = $form.validate(config);
		return this.validator;
	};
		
	this.reset = function(){
		this.setValue(this.originValue);
	};
	
	this.getJQForm = function(){
		return $form;
	}
	this.setValue = function(obj){
		this.originValue = eval("obj="+JSON.stringify(obj));
		for(key in editors){
			var editor = editors[key];
			if(typeof(editor)!="function"){
				editor.setValue(obj);
			}
		}
		this.value = obj;
	}
	
	this.getValue = function(){
		for(key in editors){
			var editor = editors[key];
			if(typeof(editor)!="function"){
				if(editor.getName().indexOf(".")>0)
					CSST.UI.setProperty(this.value,editor.getName(),editor.getValue());
				else
					this.value[editor.getName()] = editor.getValue();
				
			}
		}
		return this.value;
	}
	
	
	var sb =('<span class="inputWrap"><span class="inputWrapInner"></span></span>');
	var sb2 = ('<span class="inputWrap2"><span class="inputWrapInner"></span></span>');

	$('input[type=text],input[type=password]',"#"+formId).each(function(){		
		editors[$(this).attr("name")] = new CSST.UI.TextInput($(this),thisForm);	
		var oWidth = $(this).width();		
		if($(this).attr("readonly")=="readonly" || $(this).attr("disabled")=="disabled"){
			$(this).addClass("inputTextWrap").wrap(sb2);		
		}else
		{
			$(this).addClass("inputTextWrap").wrap(sb);
		}
		$(this).width(oWidth);
		if($('.searchForm').length > 0)
			$(this).width($(this).attr("size")*10);
		$(this).focus(function(){
					$(this).parent().parent('.inputWrap').addClass("inputWrap_hover");
				}).blur(function(){
					$(this).parent().parent('.inputWrap').removeClass("inputWrap_hover");
		});

	});
	$('input[type=posPicker]',"#"+formId).each(function(){
		if($('.searchForm').length > 0)
			$(this).width($(this).attr("size")*10);
		$(this).attr("readonly","true");
		editors[$(this).attr("name")] = new CSST.UI.PosInput($(this),thisForm);	
		var oWidth = $(this).width();		
		$(this).addClass("inputTextWrap").wrap(sb);
		$('<span class="inputTypeIcon icon_map"></span>').insertAfter($(this));
		$(this).width(oWidth-22);201202200001
		$(this).focus(function(){
					$(this).parent().parent('.inputWrap').addClass("inputWrap_hover");
				}).blur(function(){
					$(this).parent().parent('.inputWrap').removeClass("inputWrap_hover");
		});
	});
	
	$('input[type=calendar]',"#"+formId).each(function(){
		editors[$(this).attr("name")] = new CSST.UI.CalendarInput($(this),thisForm);
		var oWidth = $(this).width();		
		$(this).addClass("inputTextWrap").wrap(sb);
		$('<span class="inputTypeIcon icon_calendar"></span>').insertAfter($(this));
		$(this).width(oWidth-22);
		$(this).focus(function(){
					$(this).parent().parent('.inputWrap').addClass("inputWrap_hover");
				}).blur(function(){
					$(this).parent().parent('.inputWrap').removeClass("inputWrap_hover");
		});
	});
	$('input[type=csstSearch]',"#"+formId).each(function(){
		editors[$(this).attr("name")] = new CSST.UI.TextInput($(this),thisForm);
		var oWidth = $(this).width();		
		$(this).addClass("inputTextWrap").wrap(sb);
		$('<span class="inputTypeIcon icon_search"></span>').insertAfter($(this));
		$(this).width(oWidth-22);
		$(this).focus(function(){
					$(this).parent().parent('.inputWrap').addClass("inputWrap_hover");
				}).blur(function(){
					$(this).parent().parent('.inputWrap').removeClass("inputWrap_hover");
		});
	});
	
	$('input[type=time]',"#"+formId).each(function(){
		var name = $(this).attr("name");
		var dd=[];
		dd.push('<span class="timeWrapper">');
		dd.push('<span class="inputWrap"><span class="inputWrapInner"><input class="inputTextWrap" type="text" name="'+name+'_h"/><span class="timeOption"><span class="timeAdd"></span><span class="timeMinus"></span></span></span></span>：');
		dd.push('<span class="inputWrap"><span class="inputWrapInner"><input class="inputTextWrap" type="text" name="'+name+'_m"/><span class="timeOption"><span class="timeAdd"></span><span class="timeMinus"></span></span></span></span>：');
		dd.push('<span class="inputWrap"><span class="inputWrapInner"><input class="inputTextWrap" type="text" name="'+name+'_s"/><span class="timeOption"><span class="timeAdd"></span><span class="timeMinus"></span></span></span></span>');
		dd.push('</span>');
		var timeHtml = dd.join('');
		$(this).css("display","none");
		$(timeHtml).insertAfter($(this));			
		editors[name] = new CSST.UI.TimeInput($(this),thisForm);
		$(".timeWrapper>.inputWrap>.inputWrapInner>.inputTextWrap").css("text-align","right");
		$('input[name="'+name+'_h"]').css('width','34');//分跟秒最多2位数字。
		$('input[name="'+name+'_m"]').css('width','16');
		$('input[name="'+name+'_s"]').css('width','16');
		$(".timeWrapper>.inputWrap>.inputWrapInner>.inputTextWrap").focus(function(){			
					$(this).parent().parent('.inputWrap').addClass("inputWrap_hover");
		}).blur(function(){
					$(this).parent().parent('.inputWrap').removeClass("inputWrap_hover");
		});
		$(".timeWrapper>.inputWrap>.inputWrapInner>.timeOption>.timeAdd").hover(function(){
			
					$(this).parent().parent('.inputWrap').addClass("inputWrap_hover");
		},
		function(){
					$(this).parent().parent('.inputWrap').removeClass("inputWrap_hover");
		});
		$(".timeWrapper>.inputWrap>.inputWrapInner>.timeOption>.timeAdd").hover(
				  function () {
					$(this).addClass("timeAddCur");
				  },
				  function () {
					$(this).removeClass("timeAddCur");
		 });	
		 $(".timeWrapper>.inputWrap>.inputWrapInner>.timeOption>.timeMinus").hover(
				  function () {
					$(this).addClass("timeMinusCur");
				  },
				  function () {
					$(this).removeClass("timeMinusCur");
		 });
		 $('input[name="'+name+'_h"]').parent().children(".timeOption").children(".timeAdd").mousedown(function(){
			 editors[name].increase("h");
		 })
		 $('input[name="'+name+'_m"]').parent().children(".timeOption").children(".timeAdd").mousedown(function(){
			 editors[name].increase("m");
		 })
		 $('input[name="'+name+'_s"]').parent().children(".timeOption").children(".timeAdd").mousedown(function(){
			 editors[name].increase("s");
		 })
		  $('input[name="'+name+'_h"]').parent().children(".timeOption").children(".timeMinus").mousedown(function(){
			 editors[name].reduce("h");
		 })
		 $('input[name="'+name+'_m"]').parent().children(".timeOption").children(".timeMinus").mousedown(function(){
			 editors[name].reduce("m");
		 })
		 $('input[name="'+name+'_s"]').parent().children(".timeOption").children(".timeMinus").mousedown(function(){
			 editors[name].reduce("s");
		 })			
	});
	
	
	
	$('input[type=checkbox]',"#"+formId).each(function(){
		var $this = $(this);
		var name = $this.attr("name");
		if(editors[name]!=null)
			return;
		editors[name] = new CSST.UI.CheckInput($(this),thisForm);	
	});
	
	$('input[type=radio]',"#"+formId).each(function(){
		var $this = $(this);
		var name = $this.attr("name");
		if(editors[name]!=null)
			return;
		editors[name] = new CSST.UI.RadioInput($(this),thisForm);
		
	});
	$('input[type=file]',"#"+formId).each(function(){
		var $this = $(this);
		$this.attr("size","1");
		if ($.browser.msie ){
			$this.css("left","-37px");
		}else if($.browser.mozilla)
		{
			$this.css("left","-9px");
		}else if($.browser.opera)
		{
			$this.css("left","-11px");
		}
		$this.addClass('csstFile').wrap('<span class="fileWrapper"></span>');
		$this.parent("span.fileWrapper").hover(function(){$(this).addClass("curFile")},function(){$(this).removeClass("curFile")});	
		//var fileFrame = $('<iframe src="/pp/resources/js/temp.html" width="100%" height="150" id='+$this.attr("name")+' name='+$this.attr("name")+' frameborder="0" allowtransparency="ture"></iframe>');
		//fileFrame.insertAfter($this.parent("span.fileWrapper"));
		//fileFrame.contents().find("body").addClass('uploadingBody');
		//var i= 0;
		/***
		 * 
		 $this.bind("change",function(){
			var name = $this.val();
			var p = name.lastIndexOf("\\");
			name = name.substring(p+1);			 
			var fileDiv =$('<div class="fileDiv"><div class="filePath" id="filePath'+i+'"></div><div class="fileUploadSta loading"></div></div>');
			fileFrame.contents().find("body.uploadingBody").append(fileDiv);
			fileFrame.contents().find('#filePath'+i+'').html(name);
			if(i%2 != 0){
				fileFrame.contents().find('#filePath'+i+'').parent('.fileDiv').css('background','#444444');	
			}
			i++;
		})
		*/
	}); 
	$('input[type=button],input[type=submit],input[type=reset]',"#"+formId).each(function(){
		$(this).replaceWith('<button id="'+ this.id +'" name="'+ this.name +'" type="'+ this.type +'" class="csstbutton"><span><span>'+ $(this).attr('value') +'</span></span></button>');
		$("button.csstbutton").hover(function(){$(this).addClass("curBtn")},function(){$(this).removeClass("curBtn")});
		$("#popBtnBarId").find("button").eq(0).addClass("curBtn");
	
	});                                                                                                                                                            	
	
	$('select',"#"+formId).each(function(index){
		var current = $(this);
		var name = $(this).attr("name");
		if(1*$(this).attr("size")>1){
			editors[name] = new CSST.UI.Multiple_selInput($(this),thisForm);
		}else{
			editors[name] = new CSST.UI.Single_selInput($(this),thisForm);
		}
	});
};


