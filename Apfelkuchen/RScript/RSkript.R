prepareProjection<-function(u_roles,roleList,debug)
{ #wird vor oder von suggestVmatrix gebraucht 
  colnum<-Reduce("+",lapply(roleList,function(x) sum(u_roles==x)))
  inx<-matrix(0,nrow=nrow(u_roles),ncol=colnum)
  rownames(inx)<-rownames(u_roles)
  if(colnum)colnames(inx)<-1:colnum
  begin<-1
  for(x in roleList){
     if(debug) print(x)
     sp<-u_roles==x
     x_ind<-as.array(1:length(sp))[sp]
     if(length(x_ind)) {
       colnames(inx)[begin:(begin-1+length(x_ind))]<-rownames(u_roles)[x_ind]
       inx[x_ind,begin:(begin-1+length(x_ind))]<-diag(1,nrow=length(x_ind))
       if(debug) print(inx[,begin:(begin-1+length(x_ind))])#has a col for each  x-factor
     }
     begin<-begin+length(x_ind)
  }
  return(inx)   #inx ist eine Matrix mit so vielen einsen wie Spalten, ansonsten  Nullen
                #Sie kann verwendet werden, um die Reienfolge von Spalten einer  Matrix umzusortieren
}




suggestVmatrix<-function(u_roles,D,role,debug)
#suggestVmatrix<-function(D,E2,debug)    alternative Signatur, wenn E2 vor dem  Aufruf bestimmt wird
{
  #role no longer used, can be removedwird nicht mehr gebraucht, kann entfernt  werden
  #Vorsicht: es sind hart-kodierte Namen im Aufruf von prepareProjection(...)
  role<-role
  E2<-t(prepareProjection(u_roles,c("constant","controlled","scale-up","dependent"),debug))
  if(debug) if(nrow(D)!=nrow(E2)) print("number of rows in D and E2 is not the  same")
  if(debug) if(!identical(rownames(D),colnames(E2))) print("rownames in D and E2  are not the same")

  r<-qr(D,tol=1e-07)$rank
  n<-nrow(D)
  D<-E2%*%D
  
  if(r==n){   # impossible to make things dimensionless: return unity matrix 
    V<-matrix(0,nrow=n,ncol=n)
    colnames(V)<-paste("PI",1:ncol(V),sep="")
    rownames(V)<-rownames(D)
  } else {
    E<-matrix(0,nrow=n,ncol=n)
    diag(E)<-1	#E is a permutation matrix (at the moment just identity)

    i<-1
    j<-0
    while(i<=r){
      if(qr(D[(1:i),],tol=1e-07)$rank==i) {
        i<-i+1	#full rank up to now: no need to permute the row away    
      } else {    #row is permuted (not switched!) with row n-j
        cache<-D[i,]
        D[i:(n-j-1),]<-D[(i+1):(n-j),]
        D[n-j,]<-cache
        cache<-E[i,]
	  E[i:(n-j-1),]<-E[(i+1):(n-j),]
	  E[n-j,]<-cache
        j<-j+1
	}
    }  
    V<-matrix(0,nrow=n,ncol=n-r)
    colnames(V)<-paste("PI",1:ncol(V),sep="")
    if((r+1)==n) V[(r+1),]<-1 else diag(V[(r+1):n,])<-1
    G<-qr.solve(t(D[(1:r),]),t(D))
    V[1:r,]<--G[,(r+1):n]
    V<-solve(E)%*%V
    V<-solve(E2)%*%V
  }
  r<-t(round(V,7))
  returnlist<-list(r1=r, r2=colnames(r), r3=rownames(r))
  return(returnlist)
}


  
berechneMinMax<-function(V,u_low,u_high){
	#extreme limits (from RF-limits) in DLF-space
 	x_high<-matrix(0,ncol(V))
 	x_low<-matrix(0,ncol(V))

   	for(i in 1:ncol(V))
  	{
	x_low[i]<-sum(u_low[sign(V[,i])>0]*V[sign(V[,i])>0,i])+sum(u_high[sign (V[,i])<0]*V[sign(V[,i])<0,i])
	x_high[i]<-sum(u_low[sign(V[,i])<0]*V[sign(V[,i])<0,i])+sum(u_high[sign (V[,i])>0]*V[sign(V[,i])>0,i])
 	}
 	rownames(x_low)<-colnames(V)
  	colnames(x_low)<-"l.low"
  	rownames(x_high)<-colnames(V)
  	colnames(x_high)<-"l.high"
	returnlist<-list(r1=x_low, r2=colnames(x_low), r3=rownames (x_low),r4=x_high, r5=colnames(x_high), 	r6=rownames(x_high))
	return (returnlist)
}
