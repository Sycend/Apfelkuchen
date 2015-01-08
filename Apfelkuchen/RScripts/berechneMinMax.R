  
berechneMinMax<-function(V,u_low,u_high){
	#extreme limits (from RF-limits) in DLF-space
 	x_high<-matrix(0,ncol(V))
 	x_low<-matrix(0,ncol(V))

   	for(i in 1:ncol(V))
  	{
	x_low[i]<-sum(u_low[sign(V[,i])>0]*V[sign(V[,i])>0,i])+sum(u_high[sign(V[,i])<0]*V[sign(V[,i])<0,i])
	x_high[i]<-sum(u_low[sign(V[,i])<0]*V[sign(V[,i])<0,i])+sum(u_high[sign(V[,i])>0]*V[sign(V[,i])>0,i])
 	}
 	rownames(x_low)<-colnames(V)
  	colnames(x_low)<-"l.low"
  	rownames(x_high)<-colnames(V)
  	colnames(x_high)<-"l.high"
	#return (x_low)
	return (c(x_low,colnames(x_low),rownames(x_low),x_high,colnames(x_high),rownames(x_high)))
}
