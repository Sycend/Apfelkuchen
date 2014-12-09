suggestVmatrix<-function(u_abbr,D,debug)
{
  if(debug) if(nrow(D)!=length(u_abbr)) print("number of rows in D and abbr is not the same")
  V<-matrix(0,nrow=nrow(D),ncol=nrow(D)-qr(D)$rank)
  rownames(V)<-u_abbr
  colnames(V)<-paste("PI",1:ncol(V),sep="")
  diag(V)<-1
  return(V)
}