suggestVmatrix<-function(u_roles,D,role,debug)
{
#  in_list<-prepareProjection(u_roles,debug)
#  in_scup<-in_list$in_scup
#  in_const<-in_list$in_const
#  in_compl<-in_list$in_compl

  if(debug) if(nrow(D)!=length(u_roles)) print("number of rows in D and u_roles is not the same")

#  if(role=="const") D<-t(in_const)%*%as.matrix(D)

  r<-qr(D)$rank
  n<-nrow(D)
  
  if(r==n){   # impossible to make things dimensionless return unity matrix 
    V<-matrix(0,nrow=n,ncol=n)
    colnames(V)<-paste("PI",1:ncol(V),sep="")
    rownames(V)<-rownames(D)
  } else {
# D_eff<-as.matrix(D[,apply(D,2,function(x) sum(x^2))!=0])
# D_eff<-D_eff%*%qr.solve(qr(D_eff)$qr)
# D_eff<-as.matrix(D[,apply(D,2,function(x) sum(x^2))!=0])
    E<-matrix(0,nrow=n,ncol=n)
    diag(E)<-1	

    i<-1
    j<-0
    rnlist<-rownames(D)
    F<-D
    while(i<r){
      if(qr(D[(1:i),])$rank==i) {
        i<-i+1	    
      } else {
        cache<-D[i,]
        D[i:(nrow(D)-j-1),]<-D[(i+1):(nrow(D)-j),]
        D[nrow(D)-j,]<-cache
        cache<-E[i,]
	  E[i:(nrow(E)-j-1),]<-E[(i+1):(nrow(E)-j),]
	  E[nrow(E)-j,]<-cache
        rnlist[i:(nrow(D)-j-1)]<-rnlist[(i+1):(nrow(D)-j)]
 	  rnlist[(nrow(D)-j)]<-rownames(D)[i]
        j<-j+1
	}
    }  
    rownames(E)<-rnlist
    colnames(E)<-rownames(D)
    V<-matrix(0,nrow=n,ncol=n-r)
    colnames(V)<-paste("PI",1:ncol(V),sep="")
    rownames(V)<-rownames(E)
    if((r+1)==n) V[(r+1),]<-1 else diag(V[(r+1):n,])<-1
    D<-E%*%F
    G<-qr.solve(t(D[(1:r),]),t(D))
#  G<-qr.solve(D_eff[(1:r),],D_eff[(r+1):n,])
    V[1:r,]<--G[,(r+1):n]
  }
  return(solve(E)%*%V)
} 



  
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
	returnlist<-list(r1=x_low, r2=colnames(x_low), r3=rownames(x_low),r4=x_high, r5=colnames(x_high), 	r6=rownames(x_high))
	return (returnlist)
}
