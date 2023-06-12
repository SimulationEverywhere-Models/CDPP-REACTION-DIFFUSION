#include(ReactionDiffusion.inc)

[top]
components : rd

[rd]
type : cell
dim : (5,5,5,2)
delay : transport  
defaultDelayTime : 100

border : nowrapped

neighbors : rd(0,0,-1,0) rd(-1,0,0,0) rd(0,0,1,0) 
neighbors : rd(0,-1,0,0) rd(0,0,0,0) rd(0,1,0,0)
neighbors :              rd(1,0,0,0)
neighbors :              rd(0,0,0,-1)
neighbors : rd(0,0,-1,1) rd(-1,0,0,1) rd(0,0,1,1)
neighbors : rd(0,-1,0,1) rd(0,0,0,1) rd(0,1,0,1)
neighbors :              rd(1,0,0,1)

initialvalue : 100.0
initialCellsValue : ReactionDiffusion.val
localtransition : rd-rule

zone : rd-rule { (0,0,0,0)..(4,4,4,0) }
zone : memory-rule { (0,0,0,1)..(4,4,4,1) }


[memory-rule]
rule : {(0,0,0,-1)} 100 { t }

[rd-rule]
rule : {(#macro(diffusion) - (0,0,0,1)) / 100 } 100 { t }

